/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package org.observertc.webrtc.schemas.reports;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class Report extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 2112698269632327706L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Report\",\"namespace\":\"org.observertc.webrtc.schemas.reports\",\"fields\":[{\"name\":\"serviceUUID\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"serviceName\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"customProvided\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"timestamp\",\"type\":\"long\"},{\"name\":\"payload\",\"type\":[\"null\",{\"type\":\"record\",\"name\":\"InitiatedCall\",\"fields\":[{\"name\":\"callUUID\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"callName\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null}]},{\"type\":\"record\",\"name\":\"FinishedCall\",\"fields\":[{\"name\":\"callUUID\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"callName\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null}]},{\"type\":\"record\",\"name\":\"JoinedPeerConnection\",\"fields\":[{\"name\":\"mediaUnitId\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"callUUID\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"callName\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"userId\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"browserId\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"peerConnectionUUID\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}]},{\"type\":\"record\",\"name\":\"DetachedPeerConnection\",\"fields\":[{\"name\":\"mediaUnitId\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"callUUID\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"callName\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"userId\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"browserId\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"peerConnectionUUID\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}]},{\"type\":\"record\",\"name\":\"InboundRTP\",\"fields\":[{\"name\":\"mediaUnitId\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"callName\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"userId\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"browserId\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"peerConnectionUUID\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"ssrc\",\"type\":\"long\"},{\"name\":\"bytesReceived\",\"type\":[\"null\",\"long\"],\"default\":null},{\"name\":\"codecId\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"decoderImplementation\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"estimatedPlayoutTimestamp\",\"type\":[\"null\",\"double\"],\"default\":null},{\"name\":\"fecPacketsDiscarded\",\"type\":[\"null\",\"int\"],\"default\":null},{\"name\":\"fecPacketsReceived\",\"type\":[\"null\",\"int\"],\"default\":null},{\"name\":\"firCount\",\"type\":[\"null\",\"int\"],\"default\":null},{\"name\":\"framesDecoded\",\"type\":[\"null\",\"int\"],\"default\":null},{\"name\":\"headerBytesReceived\",\"type\":[\"null\",\"long\"],\"default\":null},{\"name\":\"id\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"isRemote\",\"type\":[\"null\",\"boolean\"],\"default\":null},{\"name\":\"jitter\",\"type\":[\"null\",\"double\"],\"default\":null},{\"name\":\"keyFramesDecoded\",\"type\":[\"null\",\"int\"],\"default\":null},{\"name\":\"lastPacketReceivedTimestamp\",\"type\":[\"null\",\"double\"],\"default\":null},{\"name\":\"mediaType\",\"type\":{\"type\":\"enum\",\"name\":\"MediaType\",\"symbols\":[\"AUDIO\",\"VIDEO\",\"UNKNOWN\",\"NULL\"]},\"default\":\"UNKNOWN\"},{\"name\":\"nackCount\",\"type\":[\"null\",\"int\"],\"default\":null},{\"name\":\"packetsLost\",\"type\":[\"null\",\"int\"],\"default\":null},{\"name\":\"packetsReceived\",\"type\":[\"null\",\"int\"],\"default\":null},{\"name\":\"pliCount\",\"type\":[\"null\",\"int\"],\"default\":null},{\"name\":\"qpSum\",\"type\":[\"null\",\"double\"],\"default\":null},{\"name\":\"totalDecodeTime\",\"type\":[\"null\",\"double\"],\"default\":null},{\"name\":\"totalInterFrameDelay\",\"type\":[\"null\",\"double\"],\"default\":null},{\"name\":\"totalSquaredInterFrameDelay\",\"type\":[\"null\",\"double\"],\"default\":null},{\"name\":\"trackId\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"transportId\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null}]},{\"type\":\"record\",\"name\":\"OutboundRTP\",\"fields\":[{\"name\":\"mediaUnitId\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"callName\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"userId\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"browserId\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"peerConnectionUUID\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"ssrc\",\"type\":\"long\"},{\"name\":\"bytesSent\",\"type\":[\"null\",\"long\"],\"default\":null},{\"name\":\"codecID\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"encoderImplementation\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"firCount\",\"type\":[\"null\",\"int\"],\"default\":null},{\"name\":\"framesEncoded\",\"type\":[\"null\",\"int\"],\"default\":null},{\"name\":\"headerBytesSent\",\"type\":[\"null\",\"long\"],\"default\":null},{\"name\":\"id\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"isRemote\",\"type\":[\"null\",\"boolean\"],\"default\":null},{\"name\":\"keyFramesEncoded\",\"type\":[\"null\",\"long\"],\"default\":null},{\"name\":\"mediaSourceID\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"mediaType\",\"type\":\"MediaType\",\"default\":\"UNKNOWN\"},{\"name\":\"nackCount\",\"type\":[\"null\",\"int\"],\"default\":null},{\"name\":\"packetsSent\",\"type\":[\"null\",\"int\"],\"default\":null},{\"name\":\"pliCount\",\"type\":[\"null\",\"int\"],\"default\":null},{\"name\":\"qpSum\",\"type\":[\"null\",\"double\"],\"default\":null},{\"name\":\"qualityLimitationReason\",\"type\":{\"type\":\"enum\",\"name\":\"RTCQualityLimitationReason\",\"symbols\":[\"BANDWIDTH\",\"CPU\",\"NONE\",\"OTHER\",\"UNKNOWN\",\"NULL\"]},\"default\":\"unknown\"},{\"name\":\"qualityLimitationResolutionChanges\",\"type\":[\"null\",\"long\"],\"default\":null},{\"name\":\"remoteID\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"retransmittedBytesSent\",\"type\":[\"null\",\"long\"],\"default\":null},{\"name\":\"retransmittedPacketsSent\",\"type\":[\"null\",\"int\"],\"default\":null},{\"name\":\"totalEncodedBytesTarget\",\"type\":[\"null\",\"long\"],\"default\":null},{\"name\":\"totalEncodeTime\",\"type\":[\"null\",\"double\"],\"default\":null},{\"name\":\"totalPacketSendDelay\",\"type\":[\"null\",\"double\"],\"default\":null},{\"name\":\"trackID\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"transportID\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null}]},{\"type\":\"record\",\"name\":\"RemoteInboundRTP\",\"fields\":[{\"name\":\"mediaUnitId\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"callName\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"userId\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"browserId\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"peerConnectionUUID\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"ssrc\",\"type\":\"long\"},{\"name\":\"codecID\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"id\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"jitter\",\"type\":[\"null\",\"float\"],\"default\":null},{\"name\":\"localID\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"mediaType\",\"type\":\"MediaType\",\"default\":\"UNKNOWN\"},{\"name\":\"packetsLost\",\"type\":[\"null\",\"int\"],\"default\":null},{\"name\":\"roundTripTime\",\"type\":[\"null\",\"double\"],\"default\":null},{\"name\":\"transportID\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"Str","ing\"}],\"default\":null}]},{\"type\":\"record\",\"name\":\"ICECandidatePair\",\"fields\":[{\"name\":\"mediaUnitId\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"callName\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"userId\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"browserId\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"peerConnectionUUID\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"candidatePairId\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"availableOutgoingBitrate\",\"type\":[\"null\",\"int\"],\"default\":null},{\"name\":\"bytesReceived\",\"type\":[\"null\",\"long\"],\"default\":null},{\"name\":\"bytesSent\",\"type\":[\"null\",\"long\"],\"default\":null},{\"name\":\"consentRequestsSent\",\"type\":[\"null\",\"int\"],\"default\":null},{\"name\":\"currentRoundTripTime\",\"type\":[\"null\",\"double\"],\"default\":null},{\"name\":\"localCandidateID\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"nominated\",\"type\":[\"null\",\"boolean\"],\"default\":null},{\"name\":\"priority\",\"type\":[\"null\",\"long\"],\"default\":null},{\"name\":\"remoteCandidateID\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"requestsReceived\",\"type\":[\"null\",\"int\"],\"default\":null},{\"name\":\"requestsSent\",\"type\":[\"null\",\"int\"],\"default\":null},{\"name\":\"responsesReceived\",\"type\":[\"null\",\"int\"],\"default\":null},{\"name\":\"responsesSent\",\"type\":[\"null\",\"int\"],\"default\":null},{\"name\":\"state\",\"type\":{\"type\":\"enum\",\"name\":\"ICEState\",\"symbols\":[\"FAILED\",\"FROZEN\",\"IN_PROGRESS\",\"SUCCEEDED\",\"WAITING\",\"UNKNOWN\",\"NULL\"]},\"default\":\"UNKNOWN\"},{\"name\":\"totalRoundTripTime\",\"type\":[\"null\",\"double\"],\"default\":null},{\"name\":\"transportID\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"writable\",\"type\":[\"null\",\"boolean\"],\"default\":null}]},{\"type\":\"record\",\"name\":\"ICERemoteCandidate\",\"fields\":[{\"name\":\"mediaUnitId\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"callName\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"userId\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"browserId\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"peerConnectionUUID\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"candidateId\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"candidateType\",\"type\":{\"type\":\"enum\",\"name\":\"CandidateType\",\"symbols\":[\"HOST\",\"PRFLX\",\"RELAY\",\"SRFLX\",\"UNKNOWN\",\"NULL\"]}},{\"name\":\"deleted\",\"type\":[\"null\",\"boolean\"],\"default\":null},{\"name\":\"ipLSH\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"isRemote\",\"type\":[\"null\",\"boolean\"],\"default\":null},{\"name\":\"port\",\"type\":[\"null\",\"int\"],\"default\":null},{\"name\":\"priority\",\"type\":[\"null\",\"long\"],\"default\":null},{\"name\":\"protocol\",\"type\":{\"type\":\"enum\",\"name\":\"TransportProtocol\",\"symbols\":[\"UDP\",\"TCP\",\"UNKNOWN\",\"NULL\"]},\"default\":\"UNKNOWN\"},{\"name\":\"transportID\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null}]},{\"type\":\"record\",\"name\":\"ICELocalCandidate\",\"fields\":[{\"name\":\"mediaUnitId\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"callName\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"userId\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"browserId\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"peerConnectionUUID\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"candidateId\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"candidateType\",\"type\":\"CandidateType\"},{\"name\":\"deleted\",\"type\":[\"null\",\"boolean\"],\"default\":null},{\"name\":\"ipLSH\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"isRemote\",\"type\":[\"null\",\"boolean\"],\"default\":null},{\"name\":\"networkType\",\"type\":{\"type\":\"enum\",\"name\":\"NetworkType\",\"symbols\":[\"BLUETOOTH\",\"CELLULAR\",\"ETHERNET\",\"UNKNOWN\",\"VPN\",\"WIFI\",\"WIMAX\",\"NULL\"]},\"default\":\"UNKNOWN\"},{\"name\":\"port\",\"type\":[\"null\",\"int\"],\"default\":null},{\"name\":\"protocol\",\"type\":\"TransportProtocol\",\"default\":\"UNKNOWN\"},{\"name\":\"priority\",\"type\":[\"null\",\"long\"],\"default\":null},{\"name\":\"transportID\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null}]},{\"type\":\"record\",\"name\":\"Track\",\"fields\":[{\"name\":\"mediaUnitId\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"callName\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"userId\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"browserId\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"peerConnectionUUID\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"trackId\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"concealedSamples\",\"type\":[\"null\",\"int\"],\"default\":null},{\"name\":\"concealmentEvents\",\"type\":[\"null\",\"int\"],\"default\":null},{\"name\":\"detached\",\"type\":[\"null\",\"boolean\"],\"default\":null},{\"name\":\"ended\",\"type\":[\"null\",\"boolean\"],\"default\":null},{\"name\":\"framesDecoded\",\"type\":[\"null\",\"int\"],\"default\":null},{\"name\":\"framesDropped\",\"type\":[\"null\",\"int\"],\"default\":null},{\"name\":\"framesSent\",\"type\":[\"null\",\"int\"],\"default\":null},{\"name\":\"framesReceived\",\"type\":[\"null\",\"int\"],\"default\":null},{\"name\":\"hugeFramesSent\",\"type\":[\"null\",\"int\"],\"default\":null},{\"name\":\"insertedSamplesForDeceleration\",\"type\":[\"null\",\"int\"],\"default\":null},{\"name\":\"jitterBufferDelay\",\"type\":[\"null\",\"double\"],\"default\":null},{\"name\":\"jitterBufferEmittedCount\",\"type\":[\"null\",\"int\"],\"default\":null},{\"name\":\"mediaSourceID\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"mediaType\",\"type\":\"MediaType\",\"default\":\"UNKNOWN\"},{\"name\":\"remoteSource\",\"type\":[\"null\",\"boolean\"],\"default\":null},{\"name\":\"removedSamplesForAcceleration\",\"type\":[\"null\",\"int\"],\"default\":null},{\"name\":\"samplesDuration\",\"type\":[\"null\",\"double\"],\"default\":null},{\"name\":\"silentConcealedSamples\",\"type\":[\"null\",\"int\"],\"default\":null},{\"name\":\"totalSamplesReceived\",\"type\":[\"null\",\"int\"],\"default\":null}]},{\"type\":\"record\",\"name\":\"MediaSource\",\"fields\":[{\"name\":\"mediaUnitId\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"callName\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"userId\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"browserId\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"peerConnectionUUID\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"mediaSourceId\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"audioLevel\",\"type\":[\"null\",\"float\"],\"default\":null},{\"name\":\"framesPerSecond\",\"type\":[\"null\",\"double\"],\"default\":null},{\"name\":\"height\",\"type\":[\"null\",\"double\"],\"default\":null},{\"name\":\"width\",\"type\":[\"null\",\"double\"],\"default\":null},{\"name\":\"mediaType\",\"type\":\"MediaType\",\"default\":\"UNKNOWN\"},{\"name\":\"totalAudioEnergy\",\"type\":[\"null\",\"float\"],\"default\":null},{\"name\":\"totalSamplesDuration\",\"type\":[\"null\",\"double\"],\"default\":null},{\"name\":\"trackId\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null}]}],\"default\":null},{\"name\":\"type\",\"type\":{\"type\":\"enum\",\"name\":\"ReportType\",\"symbols\":[\"UNKNOWN\",\"INITIATED_CALL\",\"FINISHED_CALL\",\"JOINED_PEER_CONNECTION\",\"DETACHED_PEER_CONNECTION\",\"INBOUND_RTP\",\"REMOTE_INBOUND_RTP\",\"OUTBOUND_RTP\",\"MEDIA_SOURCE\",\"TRACK\",\"ICE_CANDIDATE_PAIR\",\"ICE_REMOTE_CANDIDATE\",\"ICE_LOCAL_CANDIDATE\"]},\"default\":\"UNKNOWN\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<Report> ENCODER =
      new BinaryMessageEncoder<Report>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<Report> DECODER =
      new BinaryMessageDecoder<Report>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<Report> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<Report> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<Report> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<Report>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this Report to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a Report from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a Report instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static Report fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

   private java.lang.String serviceUUID;
   private java.lang.String serviceName;
   private java.lang.String customProvided;
   private long timestamp;
   private java.lang.Object payload;
   private org.observertc.webrtc.schemas.reports.ReportType type;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Report() {}

  /**
   * All-args constructor.
   * @param serviceUUID The new value for serviceUUID
   * @param serviceName The new value for serviceName
   * @param customProvided The new value for customProvided
   * @param timestamp The new value for timestamp
   * @param payload The new value for payload
   * @param type The new value for type
   */
  public Report(java.lang.String serviceUUID, java.lang.String serviceName, java.lang.String customProvided, java.lang.Long timestamp, java.lang.Object payload, org.observertc.webrtc.schemas.reports.ReportType type) {
    this.serviceUUID = serviceUUID;
    this.serviceName = serviceName;
    this.customProvided = customProvided;
    this.timestamp = timestamp;
    this.payload = payload;
    this.type = type;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return serviceUUID;
    case 1: return serviceName;
    case 2: return customProvided;
    case 3: return timestamp;
    case 4: return payload;
    case 5: return type;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: serviceUUID = value$ != null ? value$.toString() : null; break;
    case 1: serviceName = value$ != null ? value$.toString() : null; break;
    case 2: customProvided = value$ != null ? value$.toString() : null; break;
    case 3: timestamp = (java.lang.Long)value$; break;
    case 4: payload = value$; break;
    case 5: type = (org.observertc.webrtc.schemas.reports.ReportType)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'serviceUUID' field.
   * @return The value of the 'serviceUUID' field.
   */
  public java.lang.String getServiceUUID() {
    return serviceUUID;
  }



  /**
   * Gets the value of the 'serviceName' field.
   * @return The value of the 'serviceName' field.
   */
  public java.lang.String getServiceName() {
    return serviceName;
  }



  /**
   * Gets the value of the 'customProvided' field.
   * @return The value of the 'customProvided' field.
   */
  public java.lang.String getCustomProvided() {
    return customProvided;
  }



  /**
   * Gets the value of the 'timestamp' field.
   * @return The value of the 'timestamp' field.
   */
  public long getTimestamp() {
    return timestamp;
  }



  /**
   * Gets the value of the 'payload' field.
   * @return The value of the 'payload' field.
   */
  public java.lang.Object getPayload() {
    return payload;
  }



  /**
   * Gets the value of the 'type' field.
   * @return The value of the 'type' field.
   */
  public org.observertc.webrtc.schemas.reports.ReportType getType() {
    return type;
  }



  /**
   * Creates a new Report RecordBuilder.
   * @return A new Report RecordBuilder
   */
  public static org.observertc.webrtc.schemas.reports.Report.Builder newBuilder() {
    return new org.observertc.webrtc.schemas.reports.Report.Builder();
  }

  /**
   * Creates a new Report RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Report RecordBuilder
   */
  public static org.observertc.webrtc.schemas.reports.Report.Builder newBuilder(org.observertc.webrtc.schemas.reports.Report.Builder other) {
    if (other == null) {
      return new org.observertc.webrtc.schemas.reports.Report.Builder();
    } else {
      return new org.observertc.webrtc.schemas.reports.Report.Builder(other);
    }
  }

  /**
   * Creates a new Report RecordBuilder by copying an existing Report instance.
   * @param other The existing instance to copy.
   * @return A new Report RecordBuilder
   */
  public static org.observertc.webrtc.schemas.reports.Report.Builder newBuilder(org.observertc.webrtc.schemas.reports.Report other) {
    if (other == null) {
      return new org.observertc.webrtc.schemas.reports.Report.Builder();
    } else {
      return new org.observertc.webrtc.schemas.reports.Report.Builder(other);
    }
  }

  /**
   * RecordBuilder for Report instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Report>
    implements org.apache.avro.data.RecordBuilder<Report> {

    private java.lang.String serviceUUID;
    private java.lang.String serviceName;
    private java.lang.String customProvided;
    private long timestamp;
    private java.lang.Object payload;
    private org.observertc.webrtc.schemas.reports.ReportType type;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(org.observertc.webrtc.schemas.reports.Report.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.serviceUUID)) {
        this.serviceUUID = data().deepCopy(fields()[0].schema(), other.serviceUUID);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.serviceName)) {
        this.serviceName = data().deepCopy(fields()[1].schema(), other.serviceName);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.customProvided)) {
        this.customProvided = data().deepCopy(fields()[2].schema(), other.customProvided);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.timestamp)) {
        this.timestamp = data().deepCopy(fields()[3].schema(), other.timestamp);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.payload)) {
        this.payload = data().deepCopy(fields()[4].schema(), other.payload);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
      if (isValidValue(fields()[5], other.type)) {
        this.type = data().deepCopy(fields()[5].schema(), other.type);
        fieldSetFlags()[5] = other.fieldSetFlags()[5];
      }
    }

    /**
     * Creates a Builder by copying an existing Report instance
     * @param other The existing instance to copy.
     */
    private Builder(org.observertc.webrtc.schemas.reports.Report other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.serviceUUID)) {
        this.serviceUUID = data().deepCopy(fields()[0].schema(), other.serviceUUID);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.serviceName)) {
        this.serviceName = data().deepCopy(fields()[1].schema(), other.serviceName);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.customProvided)) {
        this.customProvided = data().deepCopy(fields()[2].schema(), other.customProvided);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.timestamp)) {
        this.timestamp = data().deepCopy(fields()[3].schema(), other.timestamp);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.payload)) {
        this.payload = data().deepCopy(fields()[4].schema(), other.payload);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.type)) {
        this.type = data().deepCopy(fields()[5].schema(), other.type);
        fieldSetFlags()[5] = true;
      }
    }

    /**
      * Gets the value of the 'serviceUUID' field.
      * @return The value.
      */
    public java.lang.String getServiceUUID() {
      return serviceUUID;
    }


    /**
      * Sets the value of the 'serviceUUID' field.
      * @param value The value of 'serviceUUID'.
      * @return This builder.
      */
    public org.observertc.webrtc.schemas.reports.Report.Builder setServiceUUID(java.lang.String value) {
      validate(fields()[0], value);
      this.serviceUUID = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'serviceUUID' field has been set.
      * @return True if the 'serviceUUID' field has been set, false otherwise.
      */
    public boolean hasServiceUUID() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'serviceUUID' field.
      * @return This builder.
      */
    public org.observertc.webrtc.schemas.reports.Report.Builder clearServiceUUID() {
      serviceUUID = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'serviceName' field.
      * @return The value.
      */
    public java.lang.String getServiceName() {
      return serviceName;
    }


    /**
      * Sets the value of the 'serviceName' field.
      * @param value The value of 'serviceName'.
      * @return This builder.
      */
    public org.observertc.webrtc.schemas.reports.Report.Builder setServiceName(java.lang.String value) {
      validate(fields()[1], value);
      this.serviceName = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'serviceName' field has been set.
      * @return True if the 'serviceName' field has been set, false otherwise.
      */
    public boolean hasServiceName() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'serviceName' field.
      * @return This builder.
      */
    public org.observertc.webrtc.schemas.reports.Report.Builder clearServiceName() {
      serviceName = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'customProvided' field.
      * @return The value.
      */
    public java.lang.String getCustomProvided() {
      return customProvided;
    }


    /**
      * Sets the value of the 'customProvided' field.
      * @param value The value of 'customProvided'.
      * @return This builder.
      */
    public org.observertc.webrtc.schemas.reports.Report.Builder setCustomProvided(java.lang.String value) {
      validate(fields()[2], value);
      this.customProvided = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'customProvided' field has been set.
      * @return True if the 'customProvided' field has been set, false otherwise.
      */
    public boolean hasCustomProvided() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'customProvided' field.
      * @return This builder.
      */
    public org.observertc.webrtc.schemas.reports.Report.Builder clearCustomProvided() {
      customProvided = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'timestamp' field.
      * @return The value.
      */
    public long getTimestamp() {
      return timestamp;
    }


    /**
      * Sets the value of the 'timestamp' field.
      * @param value The value of 'timestamp'.
      * @return This builder.
      */
    public org.observertc.webrtc.schemas.reports.Report.Builder setTimestamp(long value) {
      validate(fields()[3], value);
      this.timestamp = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'timestamp' field has been set.
      * @return True if the 'timestamp' field has been set, false otherwise.
      */
    public boolean hasTimestamp() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'timestamp' field.
      * @return This builder.
      */
    public org.observertc.webrtc.schemas.reports.Report.Builder clearTimestamp() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'payload' field.
      * @return The value.
      */
    public java.lang.Object getPayload() {
      return payload;
    }


    /**
      * Sets the value of the 'payload' field.
      * @param value The value of 'payload'.
      * @return This builder.
      */
    public org.observertc.webrtc.schemas.reports.Report.Builder setPayload(java.lang.Object value) {
      validate(fields()[4], value);
      this.payload = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'payload' field has been set.
      * @return True if the 'payload' field has been set, false otherwise.
      */
    public boolean hasPayload() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'payload' field.
      * @return This builder.
      */
    public org.observertc.webrtc.schemas.reports.Report.Builder clearPayload() {
      payload = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'type' field.
      * @return The value.
      */
    public org.observertc.webrtc.schemas.reports.ReportType getType() {
      return type;
    }


    /**
      * Sets the value of the 'type' field.
      * @param value The value of 'type'.
      * @return This builder.
      */
    public org.observertc.webrtc.schemas.reports.Report.Builder setType(org.observertc.webrtc.schemas.reports.ReportType value) {
      validate(fields()[5], value);
      this.type = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'type' field has been set.
      * @return True if the 'type' field has been set, false otherwise.
      */
    public boolean hasType() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'type' field.
      * @return This builder.
      */
    public org.observertc.webrtc.schemas.reports.Report.Builder clearType() {
      type = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Report build() {
      try {
        Report record = new Report();
        record.serviceUUID = fieldSetFlags()[0] ? this.serviceUUID : (java.lang.String) defaultValue(fields()[0]);
        record.serviceName = fieldSetFlags()[1] ? this.serviceName : (java.lang.String) defaultValue(fields()[1]);
        record.customProvided = fieldSetFlags()[2] ? this.customProvided : (java.lang.String) defaultValue(fields()[2]);
        record.timestamp = fieldSetFlags()[3] ? this.timestamp : (java.lang.Long) defaultValue(fields()[3]);
        record.payload = fieldSetFlags()[4] ? this.payload :  defaultValue(fields()[4]);
        record.type = fieldSetFlags()[5] ? this.type : (org.observertc.webrtc.schemas.reports.ReportType) defaultValue(fields()[5]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<Report>
    WRITER$ = (org.apache.avro.io.DatumWriter<Report>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<Report>
    READER$ = (org.apache.avro.io.DatumReader<Report>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}










