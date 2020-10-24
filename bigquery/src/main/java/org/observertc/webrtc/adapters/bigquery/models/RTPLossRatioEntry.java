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

import java.util.HashMap;
import java.util.Map;
import org.observertc.webrtc.schemas.reports.MediaType;

public class RTPLossRatioEntry implements BigQueryEntry {

	public static final String SERVICE_UUID_FIELD_NAME = "serviceUUID";
	public static final String SERVICE_NAME_FIELD_NAME = "serviceName";
	public static final String CALL_UUID_FIELD_NAME = "callUUID";
	public static final String CALL_NAME_FIELD_NAME = "callName";
	public static final String MARKER_FIELD_NAME = "marker";
	public static final String REPORTED_TIMESTAMP_FIELD_NAME = "reportedTimestamp";
	public static final String STARTED_TIMESTAMP_FIELD_NAME = "startedTimestamp";
	public static final String PEER_CONNECTION_UUID_FIELD_NAME = "peerConnectionUUID";
	public static final String BROWSERID_FIELD_NAME = "browserID";
	public static final String MEDIA_UNIT_ID_FIELD_NAME = "mediaUnitID";
	public static final String MEDIA_TYPE_FIELD_NAME = "mediaType";
	public static final String USER_ID_FIELD_NAME = "userID";
	public static final String SSRC_FIELD_NAME = "SSRC";
	public static final String LOSS_RATIO_FIELD_NAME = "lossRatio";
	public static final String PACKETS_SENT_FIELD_NAME = "packetsSent";
	public static final String PACKETS_LOST_FIELD_NAME = "packetsLost";


	private final Map<String, Object> values;

	public RTPLossRatioEntry() {
		this.values = new HashMap<>();
	}

	public RTPLossRatioEntry withServiceUUID(String value) {
		this.values.put(SERVICE_UUID_FIELD_NAME, value);
		return this;
	}

	public String getServiceUUID() {
		String result = (String) this.values.get(SERVICE_UUID_FIELD_NAME);
		return result;
	}

	public RTPLossRatioEntry withCallUUID(String value) {
		this.values.put(CALL_UUID_FIELD_NAME, value);
		return this;
	}


	public RTPLossRatioEntry withServiceName(String value) {
		this.values.put(SERVICE_NAME_FIELD_NAME, value);
		return this;
	}

	public RTPLossRatioEntry withCallName(String value) {
		this.values.put(CALL_NAME_FIELD_NAME, value);
		return this;
	}

	public RTPLossRatioEntry withUserId(String value) {
		this.values.put(USER_ID_FIELD_NAME, value);
		return this;
	}


	public RTPLossRatioEntry withCustomProvided(String value) {
		this.values.put(MARKER_FIELD_NAME, value);
		return this;
	}

	public RTPLossRatioEntry withPeerConnectionUUID(String value) {
		this.values.put(PEER_CONNECTION_UUID_FIELD_NAME, value);
		return this;
	}

	public RTPLossRatioEntry withBrowserId(String value) {
		this.values.put(BROWSERID_FIELD_NAME, value);
		return this;
	}

	public RTPLossRatioEntry withSSRC(Long value) {
		this.values.put(SSRC_FIELD_NAME, value);
		return this;
	}

	public RTPLossRatioEntry withReportedTimestamp(Long value) {
		this.values.put(REPORTED_TIMESTAMP_FIELD_NAME, value);
		return this;
	}

	public RTPLossRatioEntry withMediaUnitId(String value) {
		this.values.put(MEDIA_UNIT_ID_FIELD_NAME, value);
		return this;
	}

	public RTPLossRatioEntry withMediaType(MediaType mediaType) {
		if (mediaType == null) {
			return this;
		}
		return this.withMediaType(mediaType.name());
	}

	public RTPLossRatioEntry withMediaType(String value) {
		this.values.put(MEDIA_TYPE_FIELD_NAME, value);
		return this;
	}

	public RTPLossRatioEntry withPacketsSent(Integer value) {
		this.values.put(PACKETS_SENT_FIELD_NAME, value);
		return this;
	}


	public RTPLossRatioEntry withPacketsLost(Integer value) {
		this.values.put(PACKETS_LOST_FIELD_NAME, value);
		return this;
	}

	public RTPLossRatioEntry withLossRatio(Double value) {
		this.values.put(LOSS_RATIO_FIELD_NAME, value);
		return this;
	}

	public Map<String, Object> toMap() {
		return this.values;
	}


	public RTPLossRatioEntry withStartedTimestamp(Long value) {
		this.values.put(STARTED_TIMESTAMP_FIELD_NAME, value);
		return this;
	}
}
