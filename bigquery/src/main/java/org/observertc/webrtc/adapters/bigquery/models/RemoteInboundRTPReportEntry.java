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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RemoteInboundRTPReportEntry implements BigQueryEntry {
	public static final String SERVICE_UUID_FIELD_NAME = "serviceUUID";
	public static final String SERVICE_NAME_FIELD_NAME = "serviceName";
	public static final String CALL_NAME_FIELD_NAME = "callName";
	public static final String CUSTOMER_PROVIDED_FIELD_NAME = "customerProvided";
	public static final String TIMESTAMP_FIELD_NAME = "timestamp";
	public static final String PEER_CONNECTION_UUID_FIELD_NAME = "peerConnectionUUID";
	public static final String BROWSERID_FIELD_NAME = "browserID";
	public static final String MEDIA_UNIT_ID_FIELD_NAME = "mediaUnitID";
	public static final String USER_ID_FIELD_NAME = "userID";

	public static final String SSRC_FIELD_NAME = "SSRC";
	public static final String RTT_IN_MS_FIELD_NAME = "RTT";
	public static final String PACKETSLOST_FIELD_NAME = "packetsLost";
	public static final String JITTER_FIELD_NAME = "jitter";
	public static final String CODEC_FIELD_NAME = "codec";
	public static final String MEDIA_TYPE_FIELD_NAME = "mediaType";
	public static final String TRANSPORT_ID_FIELD_NAME = "transportID";

	private final Map<String, Object> values;

	private static Logger logger = LoggerFactory.getLogger(RemoteInboundRTPReportEntry.class);

	public RemoteInboundRTPReportEntry() {
		this.values = new HashMap<>();
	}

	public RemoteInboundRTPReportEntry withServiceUUID(String value) {
		this.values.put(SERVICE_UUID_FIELD_NAME, value);
		return this;
	}

	public String getServiceUUID() {
		String result = (String) this.values.get(SERVICE_UUID_FIELD_NAME);
		return result;
	}

	public RemoteInboundRTPReportEntry withServiceName(String value) {
		this.values.put(SERVICE_NAME_FIELD_NAME, value);
		return this;
	}

	public String getServiceName() {
		String result = (String) this.values.get(SERVICE_NAME_FIELD_NAME);
		return result;
	}

	public RemoteInboundRTPReportEntry withCallName(String value) {
		this.values.put(CALL_NAME_FIELD_NAME, value);
		return this;
	}

	public String getCallName() {
		String result = (String) this.values.get(CALL_NAME_FIELD_NAME);
		return result;
	}

	public RemoteInboundRTPReportEntry withUserId(String value) {
		this.values.put(USER_ID_FIELD_NAME, value);
		return this;
	}

	public String getUserId() {
		String result = (String) this.values.get(USER_ID_FIELD_NAME);
		return result;
	}

	public RemoteInboundRTPReportEntry withCustomProvided(String value) {
		this.values.put(CUSTOMER_PROVIDED_FIELD_NAME, value);
		return this;
	}

	public String getCustomerProvided() {
		String result = (String) this.values.get(CUSTOMER_PROVIDED_FIELD_NAME);
		return result;
	}

	public RemoteInboundRTPReportEntry withPeerConnectionUUID(String value) {
		this.values.put(PEER_CONNECTION_UUID_FIELD_NAME, value);
		return this;
	}

	public String getPeerConnectionUUID() {
		String result = (String) this.values.get(PEER_CONNECTION_UUID_FIELD_NAME);
		return result;
	}

	public RemoteInboundRTPReportEntry withBrowserId(String value) {
		this.values.put(BROWSERID_FIELD_NAME, value);
		return this;
	}

	public String getBrowserId() {
		String result = (String) this.values.get(BROWSERID_FIELD_NAME);
		return result;
	}

	public RemoteInboundRTPReportEntry withTimestamp(Long value) {
		this.values.put(TIMESTAMP_FIELD_NAME, value);
		return this;
	}

	public Long getTimestamp() {
		Long result = (Long) this.values.get(TIMESTAMP_FIELD_NAME);
		return result;
	}

	public RemoteInboundRTPReportEntry withMediaUnitId(String value) {
		this.values.put(MEDIA_UNIT_ID_FIELD_NAME, value);
		return this;
	}

	public String getMediaUnitId() {
		String result = (String) this.values.get(MEDIA_UNIT_ID_FIELD_NAME);
		return result;
	}

	public RemoteInboundRTPReportEntry withMediaType(MediaType mediaType) {
		if (mediaType == null) {
			return this;
		}
		return this.withMediaType(mediaType.name());
	}

	public RemoteInboundRTPReportEntry withMediaType(String value) {
		this.values.put(MEDIA_TYPE_FIELD_NAME, value);
		return this;
	}

	public String getMediaType() {
		String result = (String) this.values.get(MEDIA_TYPE_FIELD_NAME);
		return result;
	}

	public RemoteInboundRTPReportEntry withSSRC(Long value) {
		this.values.put(SSRC_FIELD_NAME, value);
		return this;
	}

	public Long getSSRC() {
		Long result = (Long) this.values.get(SSRC_FIELD_NAME);
		return result;
	}

	public RemoteInboundRTPReportEntry withRTT(Double value) {
		this.values.put(RTT_IN_MS_FIELD_NAME, value);
		return this;
	}

	public Double getRTT() {
		Double result = (Double) this.values.get(RTT_IN_MS_FIELD_NAME);
		return result;
	}

	public RemoteInboundRTPReportEntry withPacketsLost(Integer value) {
		this.values.put(PACKETSLOST_FIELD_NAME, value);
		return this;
	}

	public Integer getPacketsLost() {
		Integer result = (Integer) this.values.get(PACKETSLOST_FIELD_NAME);
		return result;
	}

	public RemoteInboundRTPReportEntry withJitter(Float value) {
		this.values.put(JITTER_FIELD_NAME, value);
		return this;
	}

	public Float getJitter() {
		Float result = (Float) this.values.get(JITTER_FIELD_NAME);
		return result;
	}

	public RemoteInboundRTPReportEntry withCodec(String value) {
		this.values.put(CODEC_FIELD_NAME, value);
		return this;
	}

	public String getCodec() {
		String result = (String) this.values.get(CODEC_FIELD_NAME);
		return result;
	}


	public RemoteInboundRTPReportEntry withTransportId(String value) {
		this.values.put(TRANSPORT_ID_FIELD_NAME, value);
		return this;
	}

	public String getTransportId() {
		String result = (String) this.values.get(TRANSPORT_ID_FIELD_NAME);
		return result;
	}

	public Map<String, Object> toMap() {
		return this.values;
	}


}