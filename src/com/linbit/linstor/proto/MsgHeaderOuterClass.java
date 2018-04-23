// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: linstor/proto/MsgHeader.proto

package com.linbit.linstor.proto;

public final class MsgHeaderOuterClass {
  private MsgHeaderOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface MsgHeaderOrBuilder extends
      // @@protoc_insertion_point(interface_extends:com.linbit.linstor.proto.MsgHeader)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <pre>
     * Identifying number for this message
     * Immediate answers to this message will be sent
     * back with the same msg_id
     * Only provided with API calls where an answer is expected.
     * </pre>
     *
     * <code>optional int32 msg_id = 1;</code>
     */
    boolean hasMsgId();
    /**
     * <pre>
     * Identifying number for this message
     * Immediate answers to this message will be sent
     * back with the same msg_id
     * Only provided with API calls where an answer is expected.
     * </pre>
     *
     * <code>optional int32 msg_id = 1;</code>
     */
    int getMsgId();

    /**
     * <pre>
     * Name of the API call to execute
     * The message content (parameters) following this
     * message header will be processed by the API method
     * that is selected by this field
     * </pre>
     *
     * <code>required string api_call = 2;</code>
     */
    boolean hasApiCall();
    /**
     * <pre>
     * Name of the API call to execute
     * The message content (parameters) following this
     * message header will be processed by the API method
     * that is selected by this field
     * </pre>
     *
     * <code>required string api_call = 2;</code>
     */
    java.lang.String getApiCall();
    /**
     * <pre>
     * Name of the API call to execute
     * The message content (parameters) following this
     * message header will be processed by the API method
     * that is selected by this field
     * </pre>
     *
     * <code>required string api_call = 2;</code>
     */
    com.google.protobuf.ByteString
        getApiCallBytes();
  }
  /**
   * <pre>
   * Message header
   * </pre>
   *
   * Protobuf type {@code com.linbit.linstor.proto.MsgHeader}
   */
  public  static final class MsgHeader extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:com.linbit.linstor.proto.MsgHeader)
      MsgHeaderOrBuilder {
    // Use MsgHeader.newBuilder() to construct.
    private MsgHeader(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private MsgHeader() {
      msgId_ = 0;
      apiCall_ = "";
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private MsgHeader(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 8: {
              bitField0_ |= 0x00000001;
              msgId_ = input.readInt32();
              break;
            }
            case 18: {
              com.google.protobuf.ByteString bs = input.readBytes();
              bitField0_ |= 0x00000002;
              apiCall_ = bs;
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.linbit.linstor.proto.MsgHeaderOuterClass.internal_static_com_linbit_linstor_proto_MsgHeader_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.linbit.linstor.proto.MsgHeaderOuterClass.internal_static_com_linbit_linstor_proto_MsgHeader_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.linbit.linstor.proto.MsgHeaderOuterClass.MsgHeader.class, com.linbit.linstor.proto.MsgHeaderOuterClass.MsgHeader.Builder.class);
    }

    private int bitField0_;
    public static final int MSG_ID_FIELD_NUMBER = 1;
    private int msgId_;
    /**
     * <pre>
     * Identifying number for this message
     * Immediate answers to this message will be sent
     * back with the same msg_id
     * Only provided with API calls where an answer is expected.
     * </pre>
     *
     * <code>optional int32 msg_id = 1;</code>
     */
    public boolean hasMsgId() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <pre>
     * Identifying number for this message
     * Immediate answers to this message will be sent
     * back with the same msg_id
     * Only provided with API calls where an answer is expected.
     * </pre>
     *
     * <code>optional int32 msg_id = 1;</code>
     */
    public int getMsgId() {
      return msgId_;
    }

    public static final int API_CALL_FIELD_NUMBER = 2;
    private volatile java.lang.Object apiCall_;
    /**
     * <pre>
     * Name of the API call to execute
     * The message content (parameters) following this
     * message header will be processed by the API method
     * that is selected by this field
     * </pre>
     *
     * <code>required string api_call = 2;</code>
     */
    public boolean hasApiCall() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <pre>
     * Name of the API call to execute
     * The message content (parameters) following this
     * message header will be processed by the API method
     * that is selected by this field
     * </pre>
     *
     * <code>required string api_call = 2;</code>
     */
    public java.lang.String getApiCall() {
      java.lang.Object ref = apiCall_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          apiCall_ = s;
        }
        return s;
      }
    }
    /**
     * <pre>
     * Name of the API call to execute
     * The message content (parameters) following this
     * message header will be processed by the API method
     * that is selected by this field
     * </pre>
     *
     * <code>required string api_call = 2;</code>
     */
    public com.google.protobuf.ByteString
        getApiCallBytes() {
      java.lang.Object ref = apiCall_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        apiCall_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      if (!hasApiCall()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeInt32(1, msgId_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, apiCall_);
      }
      unknownFields.writeTo(output);
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(1, msgId_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, apiCall_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof com.linbit.linstor.proto.MsgHeaderOuterClass.MsgHeader)) {
        return super.equals(obj);
      }
      com.linbit.linstor.proto.MsgHeaderOuterClass.MsgHeader other = (com.linbit.linstor.proto.MsgHeaderOuterClass.MsgHeader) obj;

      boolean result = true;
      result = result && (hasMsgId() == other.hasMsgId());
      if (hasMsgId()) {
        result = result && (getMsgId()
            == other.getMsgId());
      }
      result = result && (hasApiCall() == other.hasApiCall());
      if (hasApiCall()) {
        result = result && getApiCall()
            .equals(other.getApiCall());
      }
      result = result && unknownFields.equals(other.unknownFields);
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      if (hasMsgId()) {
        hash = (37 * hash) + MSG_ID_FIELD_NUMBER;
        hash = (53 * hash) + getMsgId();
      }
      if (hasApiCall()) {
        hash = (37 * hash) + API_CALL_FIELD_NUMBER;
        hash = (53 * hash) + getApiCall().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.linbit.linstor.proto.MsgHeaderOuterClass.MsgHeader parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.linbit.linstor.proto.MsgHeaderOuterClass.MsgHeader parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.linbit.linstor.proto.MsgHeaderOuterClass.MsgHeader parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.linbit.linstor.proto.MsgHeaderOuterClass.MsgHeader parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.linbit.linstor.proto.MsgHeaderOuterClass.MsgHeader parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.linbit.linstor.proto.MsgHeaderOuterClass.MsgHeader parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.linbit.linstor.proto.MsgHeaderOuterClass.MsgHeader parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static com.linbit.linstor.proto.MsgHeaderOuterClass.MsgHeader parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.linbit.linstor.proto.MsgHeaderOuterClass.MsgHeader parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.linbit.linstor.proto.MsgHeaderOuterClass.MsgHeader parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(com.linbit.linstor.proto.MsgHeaderOuterClass.MsgHeader prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * <pre>
     * Message header
     * </pre>
     *
     * Protobuf type {@code com.linbit.linstor.proto.MsgHeader}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:com.linbit.linstor.proto.MsgHeader)
        com.linbit.linstor.proto.MsgHeaderOuterClass.MsgHeaderOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.linbit.linstor.proto.MsgHeaderOuterClass.internal_static_com_linbit_linstor_proto_MsgHeader_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.linbit.linstor.proto.MsgHeaderOuterClass.internal_static_com_linbit_linstor_proto_MsgHeader_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.linbit.linstor.proto.MsgHeaderOuterClass.MsgHeader.class, com.linbit.linstor.proto.MsgHeaderOuterClass.MsgHeader.Builder.class);
      }

      // Construct using com.linbit.linstor.proto.MsgHeaderOuterClass.MsgHeader.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        msgId_ = 0;
        bitField0_ = (bitField0_ & ~0x00000001);
        apiCall_ = "";
        bitField0_ = (bitField0_ & ~0x00000002);
        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.linbit.linstor.proto.MsgHeaderOuterClass.internal_static_com_linbit_linstor_proto_MsgHeader_descriptor;
      }

      public com.linbit.linstor.proto.MsgHeaderOuterClass.MsgHeader getDefaultInstanceForType() {
        return com.linbit.linstor.proto.MsgHeaderOuterClass.MsgHeader.getDefaultInstance();
      }

      public com.linbit.linstor.proto.MsgHeaderOuterClass.MsgHeader build() {
        com.linbit.linstor.proto.MsgHeaderOuterClass.MsgHeader result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public com.linbit.linstor.proto.MsgHeaderOuterClass.MsgHeader buildPartial() {
        com.linbit.linstor.proto.MsgHeaderOuterClass.MsgHeader result = new com.linbit.linstor.proto.MsgHeaderOuterClass.MsgHeader(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.msgId_ = msgId_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        result.apiCall_ = apiCall_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.linbit.linstor.proto.MsgHeaderOuterClass.MsgHeader) {
          return mergeFrom((com.linbit.linstor.proto.MsgHeaderOuterClass.MsgHeader)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.linbit.linstor.proto.MsgHeaderOuterClass.MsgHeader other) {
        if (other == com.linbit.linstor.proto.MsgHeaderOuterClass.MsgHeader.getDefaultInstance()) return this;
        if (other.hasMsgId()) {
          setMsgId(other.getMsgId());
        }
        if (other.hasApiCall()) {
          bitField0_ |= 0x00000002;
          apiCall_ = other.apiCall_;
          onChanged();
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        if (!hasApiCall()) {
          return false;
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.linbit.linstor.proto.MsgHeaderOuterClass.MsgHeader parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.linbit.linstor.proto.MsgHeaderOuterClass.MsgHeader) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private int msgId_ ;
      /**
       * <pre>
       * Identifying number for this message
       * Immediate answers to this message will be sent
       * back with the same msg_id
       * Only provided with API calls where an answer is expected.
       * </pre>
       *
       * <code>optional int32 msg_id = 1;</code>
       */
      public boolean hasMsgId() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <pre>
       * Identifying number for this message
       * Immediate answers to this message will be sent
       * back with the same msg_id
       * Only provided with API calls where an answer is expected.
       * </pre>
       *
       * <code>optional int32 msg_id = 1;</code>
       */
      public int getMsgId() {
        return msgId_;
      }
      /**
       * <pre>
       * Identifying number for this message
       * Immediate answers to this message will be sent
       * back with the same msg_id
       * Only provided with API calls where an answer is expected.
       * </pre>
       *
       * <code>optional int32 msg_id = 1;</code>
       */
      public Builder setMsgId(int value) {
        bitField0_ |= 0x00000001;
        msgId_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * Identifying number for this message
       * Immediate answers to this message will be sent
       * back with the same msg_id
       * Only provided with API calls where an answer is expected.
       * </pre>
       *
       * <code>optional int32 msg_id = 1;</code>
       */
      public Builder clearMsgId() {
        bitField0_ = (bitField0_ & ~0x00000001);
        msgId_ = 0;
        onChanged();
        return this;
      }

      private java.lang.Object apiCall_ = "";
      /**
       * <pre>
       * Name of the API call to execute
       * The message content (parameters) following this
       * message header will be processed by the API method
       * that is selected by this field
       * </pre>
       *
       * <code>required string api_call = 2;</code>
       */
      public boolean hasApiCall() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      /**
       * <pre>
       * Name of the API call to execute
       * The message content (parameters) following this
       * message header will be processed by the API method
       * that is selected by this field
       * </pre>
       *
       * <code>required string api_call = 2;</code>
       */
      public java.lang.String getApiCall() {
        java.lang.Object ref = apiCall_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          if (bs.isValidUtf8()) {
            apiCall_ = s;
          }
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <pre>
       * Name of the API call to execute
       * The message content (parameters) following this
       * message header will be processed by the API method
       * that is selected by this field
       * </pre>
       *
       * <code>required string api_call = 2;</code>
       */
      public com.google.protobuf.ByteString
          getApiCallBytes() {
        java.lang.Object ref = apiCall_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          apiCall_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <pre>
       * Name of the API call to execute
       * The message content (parameters) following this
       * message header will be processed by the API method
       * that is selected by this field
       * </pre>
       *
       * <code>required string api_call = 2;</code>
       */
      public Builder setApiCall(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        apiCall_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * Name of the API call to execute
       * The message content (parameters) following this
       * message header will be processed by the API method
       * that is selected by this field
       * </pre>
       *
       * <code>required string api_call = 2;</code>
       */
      public Builder clearApiCall() {
        bitField0_ = (bitField0_ & ~0x00000002);
        apiCall_ = getDefaultInstance().getApiCall();
        onChanged();
        return this;
      }
      /**
       * <pre>
       * Name of the API call to execute
       * The message content (parameters) following this
       * message header will be processed by the API method
       * that is selected by this field
       * </pre>
       *
       * <code>required string api_call = 2;</code>
       */
      public Builder setApiCallBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        apiCall_ = value;
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:com.linbit.linstor.proto.MsgHeader)
    }

    // @@protoc_insertion_point(class_scope:com.linbit.linstor.proto.MsgHeader)
    private static final com.linbit.linstor.proto.MsgHeaderOuterClass.MsgHeader DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new com.linbit.linstor.proto.MsgHeaderOuterClass.MsgHeader();
    }

    public static com.linbit.linstor.proto.MsgHeaderOuterClass.MsgHeader getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    @java.lang.Deprecated public static final com.google.protobuf.Parser<MsgHeader>
        PARSER = new com.google.protobuf.AbstractParser<MsgHeader>() {
      public MsgHeader parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new MsgHeader(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<MsgHeader> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<MsgHeader> getParserForType() {
      return PARSER;
    }

    public com.linbit.linstor.proto.MsgHeaderOuterClass.MsgHeader getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_linbit_linstor_proto_MsgHeader_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_linbit_linstor_proto_MsgHeader_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\035linstor/proto/MsgHeader.proto\022\030com.lin" +
      "bit.linstor.proto\"-\n\tMsgHeader\022\016\n\006msg_id" +
      "\030\001 \001(\005\022\020\n\010api_call\030\002 \002(\t"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_com_linbit_linstor_proto_MsgHeader_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_linbit_linstor_proto_MsgHeader_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_linbit_linstor_proto_MsgHeader_descriptor,
        new java.lang.String[] { "MsgId", "ApiCall", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
