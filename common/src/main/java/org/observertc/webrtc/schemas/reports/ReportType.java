/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package org.observertc.webrtc.schemas.reports;
@org.apache.avro.specific.AvroGenerated
public enum ReportType implements org.apache.avro.generic.GenericEnumSymbol<ReportType> {
  UNKNOWN, INITIATED_CALL, FINISHED_CALL, JOINED_PEER_CONNECTION, DETACHED_PEER_CONNECTION, INBOUND_RTP, REMOTE_INBOUND_RTP, OUTBOUND_RTP, MEDIA_SOURCE, TRACK, ICE_CANDIDATE_PAIR, ICE_REMOTE_CANDIDATE, ICE_LOCAL_CANDIDATE, USER_MEDIA_ERROR, EXTENSION  ;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"enum\",\"name\":\"ReportType\",\"namespace\":\"org.observertc.webrtc.schemas.reports\",\"symbols\":[\"UNKNOWN\",\"INITIATED_CALL\",\"FINISHED_CALL\",\"JOINED_PEER_CONNECTION\",\"DETACHED_PEER_CONNECTION\",\"INBOUND_RTP\",\"REMOTE_INBOUND_RTP\",\"OUTBOUND_RTP\",\"MEDIA_SOURCE\",\"TRACK\",\"ICE_CANDIDATE_PAIR\",\"ICE_REMOTE_CANDIDATE\",\"ICE_LOCAL_CANDIDATE\",\"USER_MEDIA_ERROR\",\"EXTENSION\"]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
}
