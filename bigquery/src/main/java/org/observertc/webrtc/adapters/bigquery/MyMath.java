package org.observertc.webrtc.adapters.bigquery;

public class MyMath {

	public static float constrainToRange(float value, float min, float max) {
		return Math.min(max, Math.max(min, value));
	}

	public static double constrainToRange(double value, double min, double max) {
		return Math.min(max, Math.max(min, value));
	}

	public static int constrainToRange(int value, int min, int max) {
		return Math.min(max, Math.max(min, value));
	}

	public static long constrainToRange(long value, long min, long max) {
		return Math.min(max, Math.max(min, value));
	}
}
