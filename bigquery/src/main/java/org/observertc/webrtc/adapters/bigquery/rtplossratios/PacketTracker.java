package org.observertc.webrtc.adapters.bigquery.rtplossratios;

public class PacketTracker {

	private int lastValue = 0;
	private int trackedValue = 0;
	private boolean initiated = false;

	public PacketTracker() {

	}

	public void update(int value) {
		if (this.initiated) {
			this.initiated = false;
			this.trackedValue = value;
			this.lastValue = value;
		}

		if (value < this.lastValue) {
			// reset happened
			this.trackedValue += value;
		} else {
			this.trackedValue += value - this.lastValue;
		}
		this.lastValue = value;
	}

	public int extractTrackedValue() {
		int result = this.trackedValue;
		this.trackedValue = 0;
		return result;
	}

}
