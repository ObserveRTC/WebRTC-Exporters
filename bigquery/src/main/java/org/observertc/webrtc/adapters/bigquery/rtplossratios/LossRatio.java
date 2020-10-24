package org.observertc.webrtc.adapters.bigquery.rtplossratios;

public class LossRatio {

	public LossRatio(int packetSent, int packetLost, double lossRatio) {
		this.lossRatio = lossRatio;
		this.packetSent = packetSent;
		this.packetLost = packetLost;
	}

	public final double lossRatio;
	public final int packetSent;
	public final int packetLost;

}
