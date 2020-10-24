/*
 * Copyright  2020 Balazs Kreith
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.observertc.webrtc.adapters.bigquery.models;

import io.micronaut.context.annotation.Prototype;
import org.observertc.webrtc.adapters.bigquery.Reporter;
import org.observertc.webrtc.adapters.bigquery.ReporterConfig;
import org.observertc.webrtc.schemas.reports.DetachedPeerConnection;
import org.observertc.webrtc.schemas.reports.FinishedCall;
import org.observertc.webrtc.schemas.reports.ICECandidatePair;
import org.observertc.webrtc.schemas.reports.ICELocalCandidate;
import org.observertc.webrtc.schemas.reports.ICERemoteCandidate;
import org.observertc.webrtc.schemas.reports.InboundRTP;
import org.observertc.webrtc.schemas.reports.InitiatedCall;
import org.observertc.webrtc.schemas.reports.JoinedPeerConnection;
import org.observertc.webrtc.schemas.reports.MediaSource;
import org.observertc.webrtc.schemas.reports.OutboundRTP;
import org.observertc.webrtc.schemas.reports.RemoteInboundRTP;
import org.observertc.webrtc.schemas.reports.Report;
import org.observertc.webrtc.schemas.reports.Track;
import org.observertc.webrtc.schemas.reports.UserMediaError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Prototype
public class BigQueryReporter implements Reporter {

	private static final Logger logger = LoggerFactory.getLogger(BigQueryReporter.class);

	private final BigQueryService bigQueryService;
	private final BigQueryTable<InitiatedCallEntry> initiatedCalls;
	private final BigQueryTable<FinishedCallEntry> finishedCalls;
	private final BigQueryTable<JoinedPeerConnectionEntry> joinedPeerConnections;
	private final BigQueryTable<DetachedPeerConnectionEntry> detachedPeerConnections;
	private final BigQueryTable<RemoteInboundRTPReportEntry> remoteInboundRTPSamples;
	private final BigQueryTable<InboundRTPReportEntry> inboundRTPSamples;
	private final BigQueryTable<OutboundRTPReportEntry> outboundRTPSamples;
	private final BigQueryTable<ICECandidatePairEntry> iceCandidatePairs;
	private final BigQueryTable<ICELocalCandidateEntry> iceLocalCandidates;
	private final BigQueryTable<ICERemoteCandidateEntry> iceRemoteCandidates;
	private final BigQueryTable<MediaSourceEntry> mediaSources;
	private final BigQueryTable<TrackReportEntry> trackReports;
	private final BigQueryTable<UserMediaErrorEntry> userMediaErrorReports;
	private final RTPLossRatiosTable rtpLossRatios;

	public BigQueryReporter(ReporterConfig.BigQueryReporterConfig config) {
		this.bigQueryService = new BigQueryService(config.projectName, config.datasetName);
		this.initiatedCalls = new BigQueryTableImpl(bigQueryService, config.initiatedCallsTable);
		this.finishedCalls = new BigQueryTableImpl(bigQueryService, config.finishedCallsTable);
		this.joinedPeerConnections = new BigQueryTableImpl(bigQueryService, config.joinedPeerConnectionsTable);
		this.detachedPeerConnections = new BigQueryTableImpl(bigQueryService, config.detachedPeerConnectionsTable);
		this.remoteInboundRTPSamples = new BigQueryTableImpl<>(bigQueryService, config.remoteInboundRTPSamplesTable);
		this.inboundRTPSamples = new BigQueryTableImpl<>(bigQueryService, config.inboundRTPSamplesTable);
		this.outboundRTPSamples = new BigQueryTableImpl<>(bigQueryService, config.outboundRTPSamplesTable);
		this.iceCandidatePairs = new BigQueryTableImpl<>(bigQueryService, config.iceCandidatePairsTable);
		this.iceLocalCandidates = new BigQueryTableImpl<>(bigQueryService, config.iceLocalCandidatesTable);
		this.iceRemoteCandidates = new BigQueryTableImpl<>(bigQueryService, config.iceRemoteCandidatesTable);
		this.trackReports = new BigQueryTableImpl<>(bigQueryService, config.trackReportsTable);
		this.mediaSources = new BigQueryTableImpl<>(bigQueryService, config.mediaSourcesTable);
		this.userMediaErrorReports = new BigQueryTableImpl<UserMediaErrorEntry>(bigQueryService, config.userMediaErrorsTable);

		this.rtpLossRatios = new RTPLossRatiosTable(bigQueryService, config.rtpLossRatiosTable);
	}

	@Override
	public void flush() {
		this.joinedPeerConnections.flush();
		this.detachedPeerConnections.flush();
		this.initiatedCalls.flush();
		this.finishedCalls.flush();
		this.iceRemoteCandidates.flush();
		this.iceLocalCandidates.flush();
		this.iceCandidatePairs.flush();
		this.inboundRTPSamples.flush();
		this.outboundRTPSamples.flush();
		this.remoteInboundRTPSamples.flush();
		this.trackReports.flush();
		this.mediaSources.flush();
		this.userMediaErrorReports.flush();
		this.rtpLossRatios.flush();
	}

	@Override
	public void processJoinedPeerConnectionReport(Report report, JoinedPeerConnection joinedPeerConnection) {

		JoinedPeerConnectionEntry entry = new JoinedPeerConnectionEntry()
				.withServiceUUID(report.getServiceUUID())
				.withServiceName(report.getServiceName())
				.withCallUUID(joinedPeerConnection.getCallUUID())
				.withCallName(joinedPeerConnection.getCallName())
				.withMarker(report.getMarker())
				.withTimestamp(report.getTimestamp())
				.withTimeZone("NOT IMPLEMENTED")
				//
				.withMediaUnitId(joinedPeerConnection.getMediaUnitId())
				.withUserId(joinedPeerConnection.getUserId())
				.withBrowserId(joinedPeerConnection.getBrowserId())
				.withPeerConnectionUUID(joinedPeerConnection.getPeerConnectionUUID())
				//
				;
		joinedPeerConnections.add(entry);
		rtpLossRatios.joinedPeerConnection(entry);
	}

	@Override
	public void processDetachedPeerConnectionReport(Report report, DetachedPeerConnection detachedPeerConnection) {
		DetachedPeerConnectionEntry entry = new DetachedPeerConnectionEntry()
				.withServiceUUID(report.getServiceUUID())
				.withServiceName(report.getServiceName())
				.withCallUUID(detachedPeerConnection.getCallUUID())
				.withCallName(detachedPeerConnection.getCallName())
				.withMarker(report.getMarker())
				.withTimestamp(report.getTimestamp())
				.withTimeZone("NOT IMPLEMENTED")
				//
				.withMediaUnitId(detachedPeerConnection.getMediaUnitId())
				.withUserId(detachedPeerConnection.getUserId())
				.withBrowserId(detachedPeerConnection.getBrowserId())
				.withPeerConnectionUUID(detachedPeerConnection.getPeerConnectionUUID())
				//
				;
		detachedPeerConnections.add(entry);
	}

	@Override
	public void processInitiatedCallReport(Report report, InitiatedCall initiatedCall) {
		InitiatedCallEntry entry = new InitiatedCallEntry()
				.withServiceUUID(report.getServiceUUID())
				.withServiceName(report.getServiceName())
				.withCallUUID(initiatedCall.getCallUUID())
				.withCallName(initiatedCall.getCallName())
				.withMarker(report.getMarker())
				.withTimestamp(report.getTimestamp())
				//
				;
		this.initiatedCalls.add(entry);
	}

	@Override
	public void processFinishedCallReport(Report report, FinishedCall finishedCall) {
		FinishedCallEntry entry = new FinishedCallEntry()
				.withServiceUUID(report.getServiceUUID())
				.withServiceName(report.getServiceName())
				.withCallUUID(finishedCall.getCallUUID())
				.withCallName(finishedCall.getCallName())
				.withMarker(report.getMarker())
				.withTimestamp(report.getTimestamp())
				// 
				;
//				finishedCalls.insert(finishedCallEntry);
		this.finishedCalls.add(entry);
	}

	@Override
	public void processRemoteInboundRTPReport(Report report, RemoteInboundRTP remoteInboundRTP) {
		RemoteInboundRTPReportEntry entry = new RemoteInboundRTPReportEntry()
				.withServiceUUID(report.getServiceUUID())
				.withServiceName(report.getServiceName())
				.withCallName(remoteInboundRTP.getCallName())
				.withMarker(report.getMarker())
				.withTimestamp(report.getTimestamp())
				//
				.withMediaUnitId(remoteInboundRTP.getMediaUnitId())
				.withUserId(remoteInboundRTP.getUserId())
				.withBrowserId(remoteInboundRTP.getBrowserId())
				.withPeerConnectionUUID(remoteInboundRTP.getPeerConnectionUUID())
				//
				.withSSRC(remoteInboundRTP.getSsrc())
				.withPacketsLost(remoteInboundRTP.getPacketsLost())
				.withRTT(remoteInboundRTP.getRoundTripTime())
				.withJitter(remoteInboundRTP.getJitter())
				.withCodec(remoteInboundRTP.getCodecID())
				.withMediaType(remoteInboundRTP.getMediaType())
				.withTransportId(remoteInboundRTP.getTransportID())
				//
				;
		remoteInboundRTPSamples.add(entry);
		rtpLossRatios.processRemoteInboundRTP(entry);
	}

	@Override
	public void processInboundRTPReport(Report report, InboundRTP inboundRTP) {
		InboundRTPReportEntry entry = new InboundRTPReportEntry()
				.withServiceUUID(report.getServiceUUID())
				.withServiceName(report.getServiceName())
				.withCallName(inboundRTP.getCallName())
				.withMarker(report.getMarker())
				.withTimestamp(report.getTimestamp())
				//
				.withMediaUnitId(inboundRTP.getMediaUnitId())
				.withUserId(inboundRTP.getUserId())
				.withBrowserId(inboundRTP.getBrowserId())
				.withPeerConnectionUUID(inboundRTP.getPeerConnectionUUID())
				//
				.withSSRC(inboundRTP.getSsrc())
				.withMediaType(inboundRTP.getMediaType())
				.withBytesReceived(inboundRTP.getBytesReceived())
				.withFirCount(inboundRTP.getFirCount())
				.withFramesDecoded(inboundRTP.getFramesDecoded())
				.withHeaderBytesReceived(inboundRTP.getHeaderBytesReceived())
				.withKeyFramesDecoded(inboundRTP.getKeyFramesDecoded())
				.withNackCount(inboundRTP.getNackCount())
				.withPacketsReceived(inboundRTP.getPacketsReceived())
				.withPLICount(inboundRTP.getPliCount())
				.withQPSum(inboundRTP.getQpSum())
				.withDecoderImplementation(inboundRTP.getDecoderImplementation())
				.withEstimatedPlayoutTimestamp(inboundRTP.getEstimatedPlayoutTimestamp())
				.withJitter(inboundRTP.getJitter())
				.withLastPacketReceivedTimestamp(inboundRTP.getLastPacketReceivedTimestamp())
				.withPacketsLost(inboundRTP.getPacketsLost())
				.withTotalDecodeTime(inboundRTP.getTotalDecodeTime())
				.withTotalInterFrameDelay(inboundRTP.getTotalInterFrameDelay())
				.withTotalSquaredInterFrameDelay(inboundRTP.getTotalSquaredInterFrameDelay())
				.withFECPacketsDiscarded(inboundRTP.getFecPacketsDiscarded())
				.withFECPacketsReceived(inboundRTP.getFecPacketsReceived())
				//
				;
//				inboundRTPSamples.insert(inboundRTPReportEntry);
		inboundRTPSamples.add(entry);
	}

	@Override
	public void processOutboundRTPReport(Report report, OutboundRTP outboundRTP) {
		OutboundRTPReportEntry entry = new OutboundRTPReportEntry()
				.withServiceUUID(report.getServiceUUID())
				.withServiceName(report.getServiceName())
				.withCallName(outboundRTP.getCallName())
				.withMarker(report.getMarker())
				.withTimestamp(report.getTimestamp())
				//
				.withMediaUnitId(outboundRTP.getMediaUnitId())
				.withUserId(outboundRTP.getUserId())
				.withBrowserId(outboundRTP.getBrowserId())
				.withPeerConnectionUUID(outboundRTP.getPeerConnectionUUID())
				//
				.withSSRC(outboundRTP.getSsrc())
				.withMediaType(outboundRTP.getMediaType())
				.withBytesSent(outboundRTP.getBytesSent())
				.withEncoderImplementation(outboundRTP.getEncoderImplementation())
				.withFirCount(outboundRTP.getFirCount())
				.withFramesEncoded(outboundRTP.getFramesEncoded())
				.withHeaderBytesSent(outboundRTP.getHeaderBytesSent())
				.withKeyFramesEncoded(outboundRTP.getKeyFramesEncoded())
				.withNackCount(outboundRTP.getNackCount())
				.withPacketsSent(outboundRTP.getPacketsSent())
				.withPLICount(outboundRTP.getPliCount())
				.withQPSum(outboundRTP.getQpSum())
				.withQualityLimitationReason(outboundRTP.getQualityLimitationReason())
				.withQualityLimitationResolutionChanges(outboundRTP.getQualityLimitationResolutionChanges())
				.withRetransmittedBytesSent(outboundRTP.getRetransmittedBytesSent())
				.withRetransmittedPacketsSent(outboundRTP.getRetransmittedPacketsSent())
				.withTotalEncodedTime(outboundRTP.getTotalEncodeTime())
				.withTotalPacketsSendDelay(outboundRTP.getTotalPacketSendDelay())
				.withTotalEncodedByesTarget(outboundRTP.getTotalEncodedBytesTarget());
		outboundRTPSamples.add(entry);
		rtpLossRatios.processOutboundRTP(entry);
	}

	@Override
	public void processICECandidatePairReport(Report report, ICECandidatePair iceCandidatePair) {
		ICECandidatePairEntry entry = new ICECandidatePairEntry()
				.withServiceUUID(report.getServiceUUID())
				.withServiceName(report.getServiceName())
				.withCallName(iceCandidatePair.getCallName())
				.withMarker(report.getMarker())
				.withTimestamp(report.getTimestamp())
				//
				.withMediaUnitId(iceCandidatePair.getMediaUnitId())
				.withUserId(iceCandidatePair.getUserId())
				.withBrowserId(iceCandidatePair.getBrowserId())
				.withPeerConnectionUUID(iceCandidatePair.getPeerConnectionUUID())
				//
				.withCandidatePairId(iceCandidatePair.getCandidatePairId())
				.withLocalCandidateId(iceCandidatePair.getLocalCandidateID())
				.withRemoteCandidateId(iceCandidatePair.getRemoteCandidateID())
				.withNominated(iceCandidatePair.getNominated())
				.withAvailableOutgoingBitrate(iceCandidatePair.getAvailableOutgoingBitrate())
				.withBytesReceived(iceCandidatePair.getBytesReceived())
				.withBytesSent(iceCandidatePair.getBytesSent())
				.withConsentRequestsSent(iceCandidatePair.getConsentRequestsSent())
				.withCurrentRoundTripTime(iceCandidatePair.getCurrentRoundTripTime())
				.withPriority(iceCandidatePair.getPriority())
				.withRequestsReceived(iceCandidatePair.getRequestsReceived())
				.withRequestsSent(iceCandidatePair.getRequestsSent())
				.withResponseReceived(iceCandidatePair.getResponsesReceived())
				.withResponseSent(iceCandidatePair.getResponsesSent())
				.withICEState(iceCandidatePair.getState())
				.withTotalRoundTripTime(iceCandidatePair.getTotalRoundTripTime())
				.withWritable(iceCandidatePair.getWritable())
				//
				;

//				iceCandidatePairs.insert(iceCandidatePairEntry);
		iceCandidatePairs.add(entry);
	}

	@Override
	public void processTrackReport(Report report, Track track) {
		TrackReportEntry entry = new TrackReportEntry()
				.withServiceUUID(report.getServiceUUID())
				.withServiceName(report.getServiceName())
				.withCallName(track.getCallName())
				.withMarker(report.getMarker())
				.withTimestamp(report.getTimestamp())
				//
				.withMediaUnitId(track.getMediaUnitId())
				.withUserId(track.getUserId())
				.withBrowserId(track.getBrowserId())
				.withPeerConnectionUUID(track.getPeerConnectionUUID())
				//
				.withTrackID(track.getTrackId())
				.withMediaType(track.getMediaType())
				.withConcealmentSamples(track.getConcealedSamples())
				.withConcealmentEvents(track.getConcealmentEvents())
				.withDetached(track.getDetached())
				.withEnded(track.getEnded())
				.withConcealedSamples(track.getConcealedSamples())
				.withFramesDecoded(track.getFramesDecoded())
				.withFramesDropped(track.getFramesDropped())
				.withFramesReceived(track.getFramesReceived())
				.withFramesSent(track.getFramesSent())
				.withHugeFramesSent(track.getHugeFramesSent())
				.withInsertedSamplesForDeceleration(track.getInsertedSamplesForDeceleration())
				.withJitterBufferDelay(track.getJitterBufferDelay())
				.withJitterBufferEmittedCount(track.getJitterBufferEmittedCount())
				.withRemoteSource(track.getRemoteSource())
				.withRemovedSamplesForAcceleration(track.getRemovedSamplesForAcceleration())
				.withSilentConcealedSamples(track.getSilentConcealedSamples())
				.withTotalSamplesReceived(track.getTotalSamplesReceived())
				.withMediaSourceID(track.getMediaSourceID());

		trackReports.add(entry);
	}

	@Override
	public void processMediaSource(Report report, MediaSource mediaSource) {
		MediaSourceEntry reportEntry = new MediaSourceEntry()
				.withServiceUUID(report.getServiceUUID())
				.withServiceName(report.getServiceName())
				.withCallName(mediaSource.getCallName())
				.withMarker(report.getMarker())
				.withTimestamp(report.getTimestamp())
				//
				.withMediaUnitId(mediaSource.getMediaUnitId())
				.withUserId(mediaSource.getUserId())
				.withBrowserId(mediaSource.getBrowserId())
				.withPeerConnectionUUID(mediaSource.getPeerConnectionUUID())
				//
				.withMediaSourceID(mediaSource.getMediaSourceId())
				.withAudioLevel(mediaSource.getAudioLevel())
				.withFramesPerSecond(mediaSource.getFramesPerSecond())
				.withHeight(mediaSource.getHeight())
				.withWidth(mediaSource.getWidth())
				.withAudioLevel(mediaSource.getAudioLevel())
				.withMediaType(mediaSource.getMediaType())
				.withTotalAudioEnergy(mediaSource.getTotalAudioEnergy())
				.withTotalSamplesDuration(mediaSource.getTotalSamplesDuration())
				//
				;

		mediaSources.add(reportEntry);
	}

	@Override
	public void processUserMediaErrorReport(Report report, UserMediaError userMediaErrorReport) {
		UserMediaErrorEntry entry = new UserMediaErrorEntry()
				.withServiceUUID(report.getServiceUUID())
				.withServiceName(report.getServiceName())
				.withCallName(userMediaErrorReport.getCallName())
				.withMarker(report.getMarker())
				.withTimestamp(report.getTimestamp())
				//
				.withUserId(userMediaErrorReport.getUserId())
				.withBrowserId(userMediaErrorReport.getBrowserId())
				.withMediaUnitId(userMediaErrorReport.getMediaUnitId())
				.withMessage(userMediaErrorReport.getMessage())
				.withPeerConnectionUUID(userMediaErrorReport.getPeerConnectionUUID())
				//
				;
		userMediaErrorReports.add(entry);
	}

	@Override
	public void processICELocalCandidateReport(Report report, ICELocalCandidate iceLocalCandidate) {
		ICELocalCandidateEntry entry = new ICELocalCandidateEntry()
				.withServiceUUID(report.getServiceUUID())
				.withServiceName(report.getServiceName())
				.withCallName(iceLocalCandidate.getCallName())
				.withMarker(report.getMarker())
				.withTimestamp(report.getTimestamp())
				//
				.withMediaUnitId(iceLocalCandidate.getMediaUnitId())
				.withUserId(iceLocalCandidate.getUserId())
				.withBrowserId(iceLocalCandidate.getBrowserId())
				.withPeerConnectionUUID(iceLocalCandidate.getPeerConnectionUUID())
				//
				.withCandidateID(iceLocalCandidate.getCandidateId())
				.withCandidateType(iceLocalCandidate.getCandidateType())
				.withDeleted(iceLocalCandidate.getDeleted())
				.withIPLSH(iceLocalCandidate.getIpLSH())
				.withNetworkType(iceLocalCandidate.getNetworkType())
				.withPort(iceLocalCandidate.getPort())
				.withPriority(iceLocalCandidate.getPriority())
				.withProtocol(iceLocalCandidate.getProtocol())
				//
				;

		iceLocalCandidates.add(entry);
	}

	@Override
	public void processICERemoteCandidateReport(Report report, ICERemoteCandidate iceRemoteCandidate) {
		ICERemoteCandidateEntry entry = new ICERemoteCandidateEntry()
				.withServiceUUID(report.getServiceUUID())
				.withServiceName(report.getServiceName())
				.withCallName(iceRemoteCandidate.getCallName())
				.withMarker(report.getMarker())
				.withTimestamp(report.getTimestamp())
				//
				.withMediaUnitId(iceRemoteCandidate.getMediaUnitId())
				.withUserId(iceRemoteCandidate.getUserId())
				.withBrowserId(iceRemoteCandidate.getBrowserId())
				.withPeerConnectionUUID(iceRemoteCandidate.getPeerConnectionUUID())
				//
				.withCandidateID(iceRemoteCandidate.getCandidateId())
				.withCandidateType(iceRemoteCandidate.getCandidateType())
				.withDeleted(iceRemoteCandidate.getDeleted())
				.withIPLSH(iceRemoteCandidate.getIpLSH())
				.withPort(iceRemoteCandidate.getPort())
				.withPriority(iceRemoteCandidate.getPriority())
				.withProtocol(iceRemoteCandidate.getProtocol())
				//
				;

		iceRemoteCandidates.add(entry);
	}


}
