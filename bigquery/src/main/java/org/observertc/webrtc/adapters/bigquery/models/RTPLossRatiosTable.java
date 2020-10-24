package org.observertc.webrtc.adapters.bigquery.models;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.function.Supplier;
import org.jooq.lambda.tuple.Tuple3;
import org.observertc.webrtc.adapters.bigquery.rtplossratios.LossRatio;
import org.observertc.webrtc.adapters.bigquery.rtplossratios.LossRatioTracker;
import org.observertc.webrtc.adapters.bigquery.rtplossratios.PeerConnectionStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RTPLossRatiosTable {

	private static final Logger logger = LoggerFactory.getLogger(RTPLossRatiosTable.class);

	private Map<String, PeerConnectionStream> peerConnectionStreams = new HashMap<>();
	private Map<String, String> pcToCallUUIDs = new HashMap<>();
	private final Map<StreamKey, LossRatioTracker> activeTrackers = new HashMap<>();
	private final Map<StreamKey, LossRatioTracker> passiveTrackers = new HashMap<>();
	private Instant lastFullCheck = Instant.now();
	private final BigQueryTableImpl<RTPLossRatioEntry> bigQueryTableImpl;

	public RTPLossRatiosTable(BigQueryService bigQueryService, String tableName) {
		this.bigQueryTableImpl = new BigQueryTableImpl<>(bigQueryService, tableName);
	}

	public void processRemoteInboundRTP(RemoteInboundRTPReportEntry remoteInboundRTPReportEntry) {
		String peerConnectionUUID = remoteInboundRTPReportEntry.getPeerConnectionUUID();
		Long SSRC = remoteInboundRTPReportEntry.getSSRC();
		if (peerConnectionUUID == null || SSRC == null) {
			logger.error("UUID of PC {} or SSRC {} is null", peerConnectionUUID, SSRC);
			return;
		}
		LossRatioTracker lossRatioTracker = this.getLossRatioTracker(
				peerConnectionUUID,
				SSRC,
				remoteInboundRTPReportEntry.getMediaType(),
				() -> new PeerConnectionStream(
						remoteInboundRTPReportEntry.getServiceUUID(),
						remoteInboundRTPReportEntry.getServiceName(),
						remoteInboundRTPReportEntry.getCallName(),
						remoteInboundRTPReportEntry.getMarker(),
						remoteInboundRTPReportEntry.getBrowserId(),
						remoteInboundRTPReportEntry.getUserId(),
						remoteInboundRTPReportEntry.getMediaUnitId(),
						remoteInboundRTPReportEntry.getPeerConnectionUUID()
				));

		Integer packetLost = remoteInboundRTPReportEntry.getPacketsLost();
		if (packetLost != null) {
			lossRatioTracker.updatePacketLost(packetLost, remoteInboundRTPReportEntry.getTimestamp());
		}
		Duration elapsed = Duration.between(lossRatioTracker.lastExtracted(), Instant.now());
		if (60 < elapsed.getSeconds()) {
			this.report(peerConnectionUUID, SSRC, lossRatioTracker);
		}
	}

	public void joinedPeerConnection(JoinedPeerConnectionEntry joinedPeerConnectionEntry) {
		String peerConnectionUUID = joinedPeerConnectionEntry.getPeerConnectionUUID();
		this.pcToCallUUIDs.put(peerConnectionUUID, joinedPeerConnectionEntry.getCallUUID());
	}


	public void processOutboundRTP(OutboundRTPReportEntry outboundRTPReportEntry) {
		String peerConnectionUUID = outboundRTPReportEntry.getPeerConnectionUUID();
		Long SSRC = outboundRTPReportEntry.getSSRC();
		if (peerConnectionUUID == null || SSRC == null) {
			logger.error("UUID of PC {} or SSRC {} is null", peerConnectionUUID, SSRC);
			return;
		}
		LossRatioTracker lossRatioTracker = this.getLossRatioTracker(
				peerConnectionUUID,
				SSRC,
				outboundRTPReportEntry.getMediaType(),
				() -> new PeerConnectionStream(
						outboundRTPReportEntry.getServiceUUID(),
						outboundRTPReportEntry.getServiceName(),
						outboundRTPReportEntry.getCallName(),
						outboundRTPReportEntry.getMarker(),
						outboundRTPReportEntry.getBrowserId(),
						outboundRTPReportEntry.getUserId(),
						outboundRTPReportEntry.getMediaUnitId(),
						outboundRTPReportEntry.getPeerConnectionUUID()
				));

		Integer packetSent = outboundRTPReportEntry.getPacketsSent();
		if (packetSent != null) {
			lossRatioTracker.updatePacketSent(packetSent, outboundRTPReportEntry.getTimestamp());
		}
		Duration elapsed = Duration.between(lossRatioTracker.lastExtracted(), Instant.now());
		if (60 < elapsed.getSeconds()) {
			this.report(peerConnectionUUID, SSRC, lossRatioTracker);
		}
	}

	public void flush() {
		Instant now = Instant.now();
		Duration duration = Duration.between(this.lastFullCheck, now);
		if (120 < duration.getSeconds()) {
			Iterator<Map.Entry<StreamKey, LossRatioTracker>> it = this.activeTrackers.entrySet().iterator();
			Queue<Tuple3<String, Long, LossRatioTracker>> queue = new LinkedList<>();
			for (; it.hasNext(); ) {
				Map.Entry<StreamKey, LossRatioTracker> entry = it.next();
				StreamKey streamKey = entry.getKey();
				LossRatioTracker lossRatioTracker = entry.getValue();
				Instant updated = lossRatioTracker.getUpdated();
				if (Duration.between(updated, now).getSeconds() < 60) {
					continue;
				}
				queue.add(new Tuple3<>(streamKey.peerConnectionUUID, streamKey.SSRC, lossRatioTracker));
			}
			queue.forEach(t -> {
				this.report(t.v1, t.v2, t.v3);
			});

			long threshold = now.minusSeconds(300).toEpochMilli();
			it = this.passiveTrackers.entrySet().iterator();
			for (; it.hasNext(); ) {
				Map.Entry<StreamKey, LossRatioTracker> entry = it.next();
				StreamKey streamKey = entry.getKey();
				LossRatioTracker lossRatioTracker = entry.getValue();
				long reported = lossRatioTracker.lastExtracted().toEpochMilli();
				if (threshold < reported) {
					continue;
				}
				// TODO: put it somewhere else, because it might remove calls with actve reporting pCs.
				this.pcToCallUUIDs.remove(streamKey.peerConnectionUUID);
				this.peerConnectionStreams.remove(streamKey.peerConnectionUUID);
				it.remove();
			}
			this.lastFullCheck = now;
		}

		this.bigQueryTableImpl.flush();
	}

	private void report(String peerConnectionUUID, Long SSRC, LossRatioTracker lossRatioTracker) {
		PeerConnectionStream peerConnectionStream = this.peerConnectionStreams.get(peerConnectionUUID);
		StreamKey streamKey = new StreamKey(peerConnectionUUID, SSRC);
		this.activeTrackers.remove(streamKey);
		LossRatio lossRatio = lossRatioTracker.extractLossRatio();
		RTPLossRatioEntry entry = new RTPLossRatioEntry()
				.withBrowserId(peerConnectionStream.browserId)
				.withCallName(peerConnectionStream.callName)
				.withCallUUID(this.pcToCallUUIDs.get(peerConnectionUUID))
				.withServiceName(peerConnectionStream.serviceName)
				.withServiceUUID(peerConnectionStream.serviceUUID)
				.withSSRC(SSRC)
				.withCustomProvided(peerConnectionStream.customerProvided)
				.withStartedTimestamp(lossRatioTracker.extractFirstUpdate())
				.withReportedTimestamp(lossRatioTracker.extractLastUpdate())
				.withPeerConnectionUUID(peerConnectionStream.peerConnectionUUID)
				.withUserId(peerConnectionStream.userId)
				.withMediaUnitId(peerConnectionStream.mediaUnitId)
				.withMediaType(lossRatioTracker.mediaType)
				//
				.withPacketsSent(lossRatio.packetSent)
				.withPacketsLost(lossRatio.packetLost)
				.withLossRatio(lossRatio.lossRatio)
				//
				;
		this.passiveTrackers.put(streamKey, lossRatioTracker);
		this.bigQueryTableImpl.add(entry);
	}


	private LossRatioTracker getLossRatioTracker(String peerConnectionUUID, Long SSRC, String mediaType,
												 Supplier<PeerConnectionStream> peerConnectionStreamSupplier) {
		StreamKey streamKey = new StreamKey(peerConnectionUUID, SSRC);
		LossRatioTracker result = this.activeTrackers.get(streamKey);
		if (result != null) {
			return result;
		}
		result = this.passiveTrackers.remove(streamKey);
		if (result != null) {
			this.activeTrackers.put(streamKey, result);
			return result;
		}
		result = new LossRatioTracker(mediaType);
		this.activeTrackers.put(streamKey, result);

		PeerConnectionStream peerConnectionStream = this.peerConnectionStreams.get(peerConnectionUUID);
		if (peerConnectionStream == null) {
			peerConnectionStream = peerConnectionStreamSupplier.get();
			this.peerConnectionStreams.put(peerConnectionUUID, peerConnectionStream);
		}
		peerConnectionStream.SSRCs.add(SSRC);
		return result;
	}

	private static class StreamKey {
		static String getStreamKey(String peeConnectionUUID, Long SSRC) {
			return String.format("%s-%d", peeConnectionUUID, SSRC);
		}

		public final String peerConnectionUUID;
		public final Long SSRC;

		private StreamKey(String peerConnectionUUID, Long SSRC) {
			this.peerConnectionUUID = peerConnectionUUID;
			this.SSRC = SSRC;
		}

		@Override
		public boolean equals(Object peer) {
			if (peer == null) {
				return false;
			}
			if (!peer.getClass().getName().equals(this.getClass().getName())) {
				return false;
			}
			StreamKey peerKey = (StreamKey) peer;
			return peerKey.peerConnectionUUID.equals(this.peerConnectionUUID) && peerKey.SSRC.equals(
					this.SSRC
			);
		}

		@Override
		public int hashCode() {
			return this.peerConnectionUUID.hashCode() + this.SSRC.hashCode();
		}
	}
}
