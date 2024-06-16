// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: test.proto
// Protobuf Java Version: 4.27.1

package net.heydel.protobuf;

/**
 * Protobuf type {@code pv_teil_2.CodeMessage}
 */
public final class CodeMessage extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:pv_teil_2.CodeMessage)
    CodeMessageOrBuilder {
private static final long serialVersionUID = 0L;
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 27,
      /* patch= */ 1,
      /* suffix= */ "",
      CodeMessage.class.getName());
  }
  // Use CodeMessage.newBuilder() to construct.
  private CodeMessage(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private CodeMessage() {
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return net.heydel.protobuf.Message.internal_static_pv_teil_2_CodeMessage_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return net.heydel.protobuf.Message.internal_static_pv_teil_2_CodeMessage_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            net.heydel.protobuf.CodeMessage.class, net.heydel.protobuf.CodeMessage.Builder.class);
  }

  private int bitField0_;
  public static final int CODE_FIELD_NUMBER = 1;
  private int code_ = 0;
  /**
   * <code>required int32 code = 1;</code>
   * @return Whether the code field is set.
   */
  @java.lang.Override
  public boolean hasCode() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <code>required int32 code = 1;</code>
   * @return The code.
   */
  @java.lang.Override
  public int getCode() {
    return code_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    if (!hasCode()) {
      memoizedIsInitialized = 0;
      return false;
    }
    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (((bitField0_ & 0x00000001) != 0)) {
      output.writeInt32(1, code_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, code_);
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof net.heydel.protobuf.CodeMessage)) {
      return super.equals(obj);
    }
    net.heydel.protobuf.CodeMessage other = (net.heydel.protobuf.CodeMessage) obj;

    if (hasCode() != other.hasCode()) return false;
    if (hasCode()) {
      if (getCode()
          != other.getCode()) return false;
    }
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasCode()) {
      hash = (37 * hash) + CODE_FIELD_NUMBER;
      hash = (53 * hash) + getCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static net.heydel.protobuf.CodeMessage parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static net.heydel.protobuf.CodeMessage parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static net.heydel.protobuf.CodeMessage parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static net.heydel.protobuf.CodeMessage parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static net.heydel.protobuf.CodeMessage parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static net.heydel.protobuf.CodeMessage parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static net.heydel.protobuf.CodeMessage parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static net.heydel.protobuf.CodeMessage parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static net.heydel.protobuf.CodeMessage parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static net.heydel.protobuf.CodeMessage parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static net.heydel.protobuf.CodeMessage parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static net.heydel.protobuf.CodeMessage parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(net.heydel.protobuf.CodeMessage prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessage.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code pv_teil_2.CodeMessage}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:pv_teil_2.CodeMessage)
      net.heydel.protobuf.CodeMessageOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return net.heydel.protobuf.Message.internal_static_pv_teil_2_CodeMessage_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return net.heydel.protobuf.Message.internal_static_pv_teil_2_CodeMessage_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              net.heydel.protobuf.CodeMessage.class, net.heydel.protobuf.CodeMessage.Builder.class);
    }

    // Construct using net.heydel.protobuf.CodeMessage.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      code_ = 0;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return net.heydel.protobuf.Message.internal_static_pv_teil_2_CodeMessage_descriptor;
    }

    @java.lang.Override
    public net.heydel.protobuf.CodeMessage getDefaultInstanceForType() {
      return net.heydel.protobuf.CodeMessage.getDefaultInstance();
    }

    @java.lang.Override
    public net.heydel.protobuf.CodeMessage build() {
      net.heydel.protobuf.CodeMessage result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public net.heydel.protobuf.CodeMessage buildPartial() {
      net.heydel.protobuf.CodeMessage result = new net.heydel.protobuf.CodeMessage(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(net.heydel.protobuf.CodeMessage result) {
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.code_ = code_;
        to_bitField0_ |= 0x00000001;
      }
      result.bitField0_ |= to_bitField0_;
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof net.heydel.protobuf.CodeMessage) {
        return mergeFrom((net.heydel.protobuf.CodeMessage)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(net.heydel.protobuf.CodeMessage other) {
      if (other == net.heydel.protobuf.CodeMessage.getDefaultInstance()) return this;
      if (other.hasCode()) {
        setCode(other.getCode());
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      if (!hasCode()) {
        return false;
      }
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 8: {
              code_ = input.readInt32();
              bitField0_ |= 0x00000001;
              break;
            } // case 8
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private int code_ ;
    /**
     * <code>required int32 code = 1;</code>
     * @return Whether the code field is set.
     */
    @java.lang.Override
    public boolean hasCode() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <code>required int32 code = 1;</code>
     * @return The code.
     */
    @java.lang.Override
    public int getCode() {
      return code_;
    }
    /**
     * <code>required int32 code = 1;</code>
     * @param value The code to set.
     * @return This builder for chaining.
     */
    public Builder setCode(int value) {

      code_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>required int32 code = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearCode() {
      bitField0_ = (bitField0_ & ~0x00000001);
      code_ = 0;
      onChanged();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:pv_teil_2.CodeMessage)
  }

  // @@protoc_insertion_point(class_scope:pv_teil_2.CodeMessage)
  private static final net.heydel.protobuf.CodeMessage DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new net.heydel.protobuf.CodeMessage();
  }

  public static net.heydel.protobuf.CodeMessage getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<CodeMessage>
      PARSER = new com.google.protobuf.AbstractParser<CodeMessage>() {
    @java.lang.Override
    public CodeMessage parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<CodeMessage> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<CodeMessage> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public net.heydel.protobuf.CodeMessage getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

