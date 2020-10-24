package org.observertc.webrtc.adapters.bigquery.rtplossratios;

import java.util.HashSet;
import java.util.Set;

public class PeerConnectionStream {
	public final String serviceUUID;
	public final String serviceName;
	public final String callName;
	public final String customerProvided;
	public final String browserId;
	public final String userId;
	public final String mediaUnitId;
	public final String peerConnectionUUID;
	public final Set<Long> SSRCs = new HashSet<>();

	public PeerConnectionStream(String serviceUUID,
								String serviceName,
								String callName,
								String customerProvided,
								String browserId,
								String userId,
								String mediaUnitId,
								String peerConnectionUUID
	) {
		this.serviceUUID = serviceUUID;
		this.serviceName = serviceName;
		this.callName = callName;
		this.customerProvided = customerProvided;
		this.browserId = browserId;
		this.userId = userId;
		this.mediaUnitId = mediaUnitId;
		this.peerConnectionUUID = peerConnectionUUID;
	}
}
