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

public class JoinedPeerConnectionEntry implements BigQueryEntry {

	public static final String SERVICE_UUID_FIELD_NAME = "serviceUUID";
	public static final String SERVICE_NAME_FIELD_NAME = "serviceName";
	public static final String CALL_UUID_FIELD_NAME = "callUUID";
	public static final String CALL_NAME_FIELD_NAME = "callName";
	public static final String MARKER_FIELD_NAME = "marker";
	public static final String TIMESTAMP_FIELD_NAME = "timestamp";
	public static final String PEER_CONNECTION_UUID_FIELD_NAME = "peerConnectionUUID";
	public static final String BROWSERID_FIELD_NAME = "browserID";
	public static final String MEDIA_UNIT_ID_FIELD_NAME = "mediaUnitID";
	public static final String USER_ID_FIELD_NAME = "userID";
	public static final String TIMEZONE_FIELD_NAME = "timeZone";


	private final Map<String, Object> values;

	public JoinedPeerConnectionEntry() {
		this.values = new HashMap<>();
	}

	public JoinedPeerConnectionEntry withServiceUUID(String value) {
		this.values.put(SERVICE_UUID_FIELD_NAME, value);
		return this;
	}

	public String getServiceUUID() {
		String result = (String) this.values.get(SERVICE_UUID_FIELD_NAME);
		return result;
	}

	public JoinedPeerConnectionEntry withServiceName(String value) {
		this.values.put(SERVICE_NAME_FIELD_NAME, value);
		return this;
	}

	public String getServiceName() {
		String result = (String) this.values.get(SERVICE_NAME_FIELD_NAME);
		return result;
	}

	public JoinedPeerConnectionEntry withCallUUID(String value) {
		this.values.put(CALL_UUID_FIELD_NAME, value);
		return this;
	}

	public String getCallUUID() {
		String result = (String) this.values.get(CALL_UUID_FIELD_NAME);
		return result;
	}


	public JoinedPeerConnectionEntry withCallName(String value) {
		this.values.put(CALL_NAME_FIELD_NAME, value);
		return this;
	}

	public String getCallName() {
		String result = (String) this.values.get(CALL_NAME_FIELD_NAME);
		return result;
	}

	public JoinedPeerConnectionEntry withUserId(String value) {
		this.values.put(USER_ID_FIELD_NAME, value);
		return this;
	}

	public String getUserId() {
		String result = (String) this.values.get(USER_ID_FIELD_NAME);
		return result;
	}

	public JoinedPeerConnectionEntry withMarker(String value) {
		this.values.put(MARKER_FIELD_NAME, value);
		return this;
	}

	public String getMarker() {
		String result = (String) this.values.get(MARKER_FIELD_NAME);
		return result;
	}

	public JoinedPeerConnectionEntry withPeerConnectionUUID(String value) {
		this.values.put(PEER_CONNECTION_UUID_FIELD_NAME, value);
		return this;
	}

	public String getPeerConnectionUUID() {
		String result = (String) this.values.get(PEER_CONNECTION_UUID_FIELD_NAME);
		return result;
	}

	public JoinedPeerConnectionEntry withBrowserId(String value) {
		this.values.put(BROWSERID_FIELD_NAME, value);
		return this;
	}

	public String getBrowserId() {
		String result = (String) this.values.get(BROWSERID_FIELD_NAME);
		return result;
	}

	public JoinedPeerConnectionEntry withTimestamp(Long value) {
		this.values.put(TIMESTAMP_FIELD_NAME, value);
		return this;
	}

	public Long getTimestamp() {
		Long result = (Long) this.values.get(TIMESTAMP_FIELD_NAME);
		return result;
	}

	public JoinedPeerConnectionEntry withMediaUnitId(String value) {
		this.values.put(MEDIA_UNIT_ID_FIELD_NAME, value);
		return this;
	}

	public String getMediaUnitId() {
		String result = (String) this.values.get(MEDIA_UNIT_ID_FIELD_NAME);
		return result;
	}

	public JoinedPeerConnectionEntry withTimeZone(String value) {
		this.values.put(TIMEZONE_FIELD_NAME, value);
		return this;
	}

	public String getTimeZone() {
		String result = (String) this.values.get(TIMEZONE_FIELD_NAME);
		return result;
	}

	public Map<String, Object> toMap() {
		return this.values;
	}


}
