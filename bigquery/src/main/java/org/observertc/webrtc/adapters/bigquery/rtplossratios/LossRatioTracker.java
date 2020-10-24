package org.observertc.webrtc.adapters.bigquery.rtplossratios;

import java.time.Instant;

public class LossRatioTracker {
	protected PacketTracker packetSentTracker = new PacketTracker();
	protected PacketTracker packetLostTracker = new PacketTracker();
	private Long lastUpdate;
	private Long firstUpdate;
	private Instant updated = Instant.now();
	private Instant extracted = Instant.now();
	public final String mediaType;

	public LossRatioTracker(String mediaType) {
		this.mediaType = mediaType;
	}


	public void updatePacketSent(int packetSent, Long timestamp) {
		this.packetSentTracker.update(packetSent);
		this.updateTimestamp(timestamp);
	}

	public void updatePacketLost(int packetSent, Long timestamp) {
		this.packetLostTracker.update(packetSent);
		this.updateTimestamp(timestamp);

	}

	private void updateTimestamp(Long timestamp) {
		this.updated = Instant.now();
		if (timestamp == null) {
			return;
		}
		if (this.firstUpdate == null) {
			this.firstUpdate = timestamp;
		} else if (timestamp < this.firstUpdate) {
			this.firstUpdate = timestamp;
		}
		if (this.lastUpdate == null) {
			this.lastUpdate = timestamp;
		} else if (this.lastUpdate < timestamp) {
			this.lastUpdate = timestamp;
		}
	}

	public Instant lastExtracted() {
		return this.extracted;
	}

	public Long getFirstUpdate() {
		return this.firstUpdate;
	}

	public Long getLastUpdate() {
		return this.lastUpdate;
	}

	public Instant getUpdated() {
		return this.updated;
	}

	public LossRatio extractLossRatio() {
		int packetLost = this.packetLostTracker.extractTrackedValue();
		int packetSent = this.packetSentTracker.extractTrackedValue();
		double LR = (double) packetLost / (double) packetSent;
		LossRatio result = new LossRatio(packetSent, packetLost, LR);
		this.extracted = Instant.now();
		return result;
	}

	public Long extractFirstUpdate() {
		Long result = this.firstUpdate;
		this.firstUpdate = null;
		return result;
	}

	public Long extractLastUpdate() {
		Long result = this.lastUpdate;
		this.lastUpdate = null;
		return result;
	}


}
