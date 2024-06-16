// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: test.proto
// Protobuf Java Version: 4.27.1

package net.heydel.protobuf;

/**
 * Protobuf type {@code pv_teil_2.MessageWrapper}
 */
public final class MessageWrapper extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:pv_teil_2.MessageWrapper)
    MessageWrapperOrBuilder {
private static final long serialVersionUID = 0L;
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 27,
      /* patch= */ 1,
      /* suffix= */ "",
      MessageWrapper.class.getName());
  }
  // Use MessageWrapper.newBuilder() to construct.
  private MessageWrapper(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private MessageWrapper() {
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return net.heydel.protobuf.Message.internal_static_pv_teil_2_MessageWrapper_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return net.heydel.protobuf.Message.internal_static_pv_teil_2_MessageWrapper_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            net.heydel.protobuf.MessageWrapper.class, net.heydel.protobuf.MessageWrapper.Builder.class);
  }

  private int messageTypeCase_ = 0;
  @SuppressWarnings("serial")
  private java.lang.Object messageType_;
  public enum MessageTypeCase
      implements com.google.protobuf.Internal.EnumLite,
          com.google.protobuf.AbstractMessage.InternalOneOfEnum {
    CHAT_MESSAGE(1),
    LOGIN_MESSAGE(2),
    CODE_MESSAGE(3),
    MESSAGETYPE_NOT_SET(0);
    private final int value;
    private MessageTypeCase(int value) {
      this.value = value;
    }
    /**
     * @param value The number of the enum to look for.
     * @return The enum associated with the given number.
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static MessageTypeCase valueOf(int value) {
      return forNumber(value);
    }

    public static MessageTypeCase forNumber(int value) {
      switch (value) {
        case 1: return CHAT_MESSAGE;
        case 2: return LOGIN_MESSAGE;
        case 3: return CODE_MESSAGE;
        case 0: return MESSAGETYPE_NOT_SET;
        default: return null;
      }
    }
    public int getNumber() {
      return this.value;
    }
  };

  public MessageTypeCase
  getMessageTypeCase() {
    return MessageTypeCase.forNumber(
        messageTypeCase_);
  }

  public static final int CHAT_MESSAGE_FIELD_NUMBER = 1;
  /**
   * <code>.pv_teil_2.ChatMessage chat_message = 1;</code>
   * @return Whether the chatMessage field is set.
   */
  @java.lang.Override
  public boolean hasChatMessage() {
    return messageTypeCase_ == 1;
  }
  /**
   * <code>.pv_teil_2.ChatMessage chat_message = 1;</code>
   * @return The chatMessage.
   */
  @java.lang.Override
  public net.heydel.protobuf.ChatMessage getChatMessage() {
    if (messageTypeCase_ == 1) {
       return (net.heydel.protobuf.ChatMessage) messageType_;
    }
    return net.heydel.protobuf.ChatMessage.getDefaultInstance();
  }
  /**
   * <code>.pv_teil_2.ChatMessage chat_message = 1;</code>
   */
  @java.lang.Override
  public net.heydel.protobuf.ChatMessageOrBuilder getChatMessageOrBuilder() {
    if (messageTypeCase_ == 1) {
       return (net.heydel.protobuf.ChatMessage) messageType_;
    }
    return net.heydel.protobuf.ChatMessage.getDefaultInstance();
  }

  public static final int LOGIN_MESSAGE_FIELD_NUMBER = 2;
  /**
   * <code>.pv_teil_2.LoginMessage login_message = 2;</code>
   * @return Whether the loginMessage field is set.
   */
  @java.lang.Override
  public boolean hasLoginMessage() {
    return messageTypeCase_ == 2;
  }
  /**
   * <code>.pv_teil_2.LoginMessage login_message = 2;</code>
   * @return The loginMessage.
   */
  @java.lang.Override
  public net.heydel.protobuf.LoginMessage getLoginMessage() {
    if (messageTypeCase_ == 2) {
       return (net.heydel.protobuf.LoginMessage) messageType_;
    }
    return net.heydel.protobuf.LoginMessage.getDefaultInstance();
  }
  /**
   * <code>.pv_teil_2.LoginMessage login_message = 2;</code>
   */
  @java.lang.Override
  public net.heydel.protobuf.LoginMessageOrBuilder getLoginMessageOrBuilder() {
    if (messageTypeCase_ == 2) {
       return (net.heydel.protobuf.LoginMessage) messageType_;
    }
    return net.heydel.protobuf.LoginMessage.getDefaultInstance();
  }

  public static final int CODE_MESSAGE_FIELD_NUMBER = 3;
  /**
   * <code>.pv_teil_2.CodeMessage code_message = 3;</code>
   * @return Whether the codeMessage field is set.
   */
  @java.lang.Override
  public boolean hasCodeMessage() {
    return messageTypeCase_ == 3;
  }
  /**
   * <code>.pv_teil_2.CodeMessage code_message = 3;</code>
   * @return The codeMessage.
   */
  @java.lang.Override
  public net.heydel.protobuf.CodeMessage getCodeMessage() {
    if (messageTypeCase_ == 3) {
       return (net.heydel.protobuf.CodeMessage) messageType_;
    }
    return net.heydel.protobuf.CodeMessage.getDefaultInstance();
  }
  /**
   * <code>.pv_teil_2.CodeMessage code_message = 3;</code>
   */
  @java.lang.Override
  public net.heydel.protobuf.CodeMessageOrBuilder getCodeMessageOrBuilder() {
    if (messageTypeCase_ == 3) {
       return (net.heydel.protobuf.CodeMessage) messageType_;
    }
    return net.heydel.protobuf.CodeMessage.getDefaultInstance();
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    if (hasChatMessage()) {
      if (!getChatMessage().isInitialized()) {
        memoizedIsInitialized = 0;
        return false;
      }
    }
    if (hasLoginMessage()) {
      if (!getLoginMessage().isInitialized()) {
        memoizedIsInitialized = 0;
        return false;
      }
    }
    if (hasCodeMessage()) {
      if (!getCodeMessage().isInitialized()) {
        memoizedIsInitialized = 0;
        return false;
      }
    }
    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (messageTypeCase_ == 1) {
      output.writeMessage(1, (net.heydel.protobuf.ChatMessage) messageType_);
    }
    if (messageTypeCase_ == 2) {
      output.writeMessage(2, (net.heydel.protobuf.LoginMessage) messageType_);
    }
    if (messageTypeCase_ == 3) {
      output.writeMessage(3, (net.heydel.protobuf.CodeMessage) messageType_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (messageTypeCase_ == 1) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, (net.heydel.protobuf.ChatMessage) messageType_);
    }
    if (messageTypeCase_ == 2) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, (net.heydel.protobuf.LoginMessage) messageType_);
    }
    if (messageTypeCase_ == 3) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, (net.heydel.protobuf.CodeMessage) messageType_);
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
    if (!(obj instanceof net.heydel.protobuf.MessageWrapper)) {
      return super.equals(obj);
    }
    net.heydel.protobuf.MessageWrapper other = (net.heydel.protobuf.MessageWrapper) obj;

    if (!getMessageTypeCase().equals(other.getMessageTypeCase())) return false;
    switch (messageTypeCase_) {
      case 1:
        if (!getChatMessage()
            .equals(other.getChatMessage())) return false;
        break;
      case 2:
        if (!getLoginMessage()
            .equals(other.getLoginMessage())) return false;
        break;
      case 3:
        if (!getCodeMessage()
            .equals(other.getCodeMessage())) return false;
        break;
      case 0:
      default:
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
    switch (messageTypeCase_) {
      case 1:
        hash = (37 * hash) + CHAT_MESSAGE_FIELD_NUMBER;
        hash = (53 * hash) + getChatMessage().hashCode();
        break;
      case 2:
        hash = (37 * hash) + LOGIN_MESSAGE_FIELD_NUMBER;
        hash = (53 * hash) + getLoginMessage().hashCode();
        break;
      case 3:
        hash = (37 * hash) + CODE_MESSAGE_FIELD_NUMBER;
        hash = (53 * hash) + getCodeMessage().hashCode();
        break;
      case 0:
      default:
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static net.heydel.protobuf.MessageWrapper parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static net.heydel.protobuf.MessageWrapper parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static net.heydel.protobuf.MessageWrapper parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static net.heydel.protobuf.MessageWrapper parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static net.heydel.protobuf.MessageWrapper parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static net.heydel.protobuf.MessageWrapper parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static net.heydel.protobuf.MessageWrapper parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static net.heydel.protobuf.MessageWrapper parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static net.heydel.protobuf.MessageWrapper parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static net.heydel.protobuf.MessageWrapper parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static net.heydel.protobuf.MessageWrapper parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static net.heydel.protobuf.MessageWrapper parseFrom(
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
  public static Builder newBuilder(net.heydel.protobuf.MessageWrapper prototype) {
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
   * Protobuf type {@code pv_teil_2.MessageWrapper}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:pv_teil_2.MessageWrapper)
      net.heydel.protobuf.MessageWrapperOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return net.heydel.protobuf.Message.internal_static_pv_teil_2_MessageWrapper_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return net.heydel.protobuf.Message.internal_static_pv_teil_2_MessageWrapper_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              net.heydel.protobuf.MessageWrapper.class, net.heydel.protobuf.MessageWrapper.Builder.class);
    }

    // Construct using net.heydel.protobuf.MessageWrapper.newBuilder()
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
      if (chatMessageBuilder_ != null) {
        chatMessageBuilder_.clear();
      }
      if (loginMessageBuilder_ != null) {
        loginMessageBuilder_.clear();
      }
      if (codeMessageBuilder_ != null) {
        codeMessageBuilder_.clear();
      }
      messageTypeCase_ = 0;
      messageType_ = null;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return net.heydel.protobuf.Message.internal_static_pv_teil_2_MessageWrapper_descriptor;
    }

    @java.lang.Override
    public net.heydel.protobuf.MessageWrapper getDefaultInstanceForType() {
      return net.heydel.protobuf.MessageWrapper.getDefaultInstance();
    }

    @java.lang.Override
    public net.heydel.protobuf.MessageWrapper build() {
      net.heydel.protobuf.MessageWrapper result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public net.heydel.protobuf.MessageWrapper buildPartial() {
      net.heydel.protobuf.MessageWrapper result = new net.heydel.protobuf.MessageWrapper(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      buildPartialOneofs(result);
      onBuilt();
      return result;
    }

    private void buildPartial0(net.heydel.protobuf.MessageWrapper result) {
      int from_bitField0_ = bitField0_;
    }

    private void buildPartialOneofs(net.heydel.protobuf.MessageWrapper result) {
      result.messageTypeCase_ = messageTypeCase_;
      result.messageType_ = this.messageType_;
      if (messageTypeCase_ == 1 &&
          chatMessageBuilder_ != null) {
        result.messageType_ = chatMessageBuilder_.build();
      }
      if (messageTypeCase_ == 2 &&
          loginMessageBuilder_ != null) {
        result.messageType_ = loginMessageBuilder_.build();
      }
      if (messageTypeCase_ == 3 &&
          codeMessageBuilder_ != null) {
        result.messageType_ = codeMessageBuilder_.build();
      }
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof net.heydel.protobuf.MessageWrapper) {
        return mergeFrom((net.heydel.protobuf.MessageWrapper)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(net.heydel.protobuf.MessageWrapper other) {
      if (other == net.heydel.protobuf.MessageWrapper.getDefaultInstance()) return this;
      switch (other.getMessageTypeCase()) {
        case CHAT_MESSAGE: {
          mergeChatMessage(other.getChatMessage());
          break;
        }
        case LOGIN_MESSAGE: {
          mergeLoginMessage(other.getLoginMessage());
          break;
        }
        case CODE_MESSAGE: {
          mergeCodeMessage(other.getCodeMessage());
          break;
        }
        case MESSAGETYPE_NOT_SET: {
          break;
        }
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      if (hasChatMessage()) {
        if (!getChatMessage().isInitialized()) {
          return false;
        }
      }
      if (hasLoginMessage()) {
        if (!getLoginMessage().isInitialized()) {
          return false;
        }
      }
      if (hasCodeMessage()) {
        if (!getCodeMessage().isInitialized()) {
          return false;
        }
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
            case 10: {
              input.readMessage(
                  getChatMessageFieldBuilder().getBuilder(),
                  extensionRegistry);
              messageTypeCase_ = 1;
              break;
            } // case 10
            case 18: {
              input.readMessage(
                  getLoginMessageFieldBuilder().getBuilder(),
                  extensionRegistry);
              messageTypeCase_ = 2;
              break;
            } // case 18
            case 26: {
              input.readMessage(
                  getCodeMessageFieldBuilder().getBuilder(),
                  extensionRegistry);
              messageTypeCase_ = 3;
              break;
            } // case 26
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
    private int messageTypeCase_ = 0;
    private java.lang.Object messageType_;
    public MessageTypeCase
        getMessageTypeCase() {
      return MessageTypeCase.forNumber(
          messageTypeCase_);
    }

    public Builder clearMessageType() {
      messageTypeCase_ = 0;
      messageType_ = null;
      onChanged();
      return this;
    }

    private int bitField0_;

    private com.google.protobuf.SingleFieldBuilder<
        net.heydel.protobuf.ChatMessage, net.heydel.protobuf.ChatMessage.Builder, net.heydel.protobuf.ChatMessageOrBuilder> chatMessageBuilder_;
    /**
     * <code>.pv_teil_2.ChatMessage chat_message = 1;</code>
     * @return Whether the chatMessage field is set.
     */
    @java.lang.Override
    public boolean hasChatMessage() {
      return messageTypeCase_ == 1;
    }
    /**
     * <code>.pv_teil_2.ChatMessage chat_message = 1;</code>
     * @return The chatMessage.
     */
    @java.lang.Override
    public net.heydel.protobuf.ChatMessage getChatMessage() {
      if (chatMessageBuilder_ == null) {
        if (messageTypeCase_ == 1) {
          return (net.heydel.protobuf.ChatMessage) messageType_;
        }
        return net.heydel.protobuf.ChatMessage.getDefaultInstance();
      } else {
        if (messageTypeCase_ == 1) {
          return chatMessageBuilder_.getMessage();
        }
        return net.heydel.protobuf.ChatMessage.getDefaultInstance();
      }
    }
    /**
     * <code>.pv_teil_2.ChatMessage chat_message = 1;</code>
     */
    public Builder setChatMessage(net.heydel.protobuf.ChatMessage value) {
      if (chatMessageBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        messageType_ = value;
        onChanged();
      } else {
        chatMessageBuilder_.setMessage(value);
      }
      messageTypeCase_ = 1;
      return this;
    }
    /**
     * <code>.pv_teil_2.ChatMessage chat_message = 1;</code>
     */
    public Builder setChatMessage(
        net.heydel.protobuf.ChatMessage.Builder builderForValue) {
      if (chatMessageBuilder_ == null) {
        messageType_ = builderForValue.build();
        onChanged();
      } else {
        chatMessageBuilder_.setMessage(builderForValue.build());
      }
      messageTypeCase_ = 1;
      return this;
    }
    /**
     * <code>.pv_teil_2.ChatMessage chat_message = 1;</code>
     */
    public Builder mergeChatMessage(net.heydel.protobuf.ChatMessage value) {
      if (chatMessageBuilder_ == null) {
        if (messageTypeCase_ == 1 &&
            messageType_ != net.heydel.protobuf.ChatMessage.getDefaultInstance()) {
          messageType_ = net.heydel.protobuf.ChatMessage.newBuilder((net.heydel.protobuf.ChatMessage) messageType_)
              .mergeFrom(value).buildPartial();
        } else {
          messageType_ = value;
        }
        onChanged();
      } else {
        if (messageTypeCase_ == 1) {
          chatMessageBuilder_.mergeFrom(value);
        } else {
          chatMessageBuilder_.setMessage(value);
        }
      }
      messageTypeCase_ = 1;
      return this;
    }
    /**
     * <code>.pv_teil_2.ChatMessage chat_message = 1;</code>
     */
    public Builder clearChatMessage() {
      if (chatMessageBuilder_ == null) {
        if (messageTypeCase_ == 1) {
          messageTypeCase_ = 0;
          messageType_ = null;
          onChanged();
        }
      } else {
        if (messageTypeCase_ == 1) {
          messageTypeCase_ = 0;
          messageType_ = null;
        }
        chatMessageBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>.pv_teil_2.ChatMessage chat_message = 1;</code>
     */
    public net.heydel.protobuf.ChatMessage.Builder getChatMessageBuilder() {
      return getChatMessageFieldBuilder().getBuilder();
    }
    /**
     * <code>.pv_teil_2.ChatMessage chat_message = 1;</code>
     */
    @java.lang.Override
    public net.heydel.protobuf.ChatMessageOrBuilder getChatMessageOrBuilder() {
      if ((messageTypeCase_ == 1) && (chatMessageBuilder_ != null)) {
        return chatMessageBuilder_.getMessageOrBuilder();
      } else {
        if (messageTypeCase_ == 1) {
          return (net.heydel.protobuf.ChatMessage) messageType_;
        }
        return net.heydel.protobuf.ChatMessage.getDefaultInstance();
      }
    }
    /**
     * <code>.pv_teil_2.ChatMessage chat_message = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilder<
        net.heydel.protobuf.ChatMessage, net.heydel.protobuf.ChatMessage.Builder, net.heydel.protobuf.ChatMessageOrBuilder> 
        getChatMessageFieldBuilder() {
      if (chatMessageBuilder_ == null) {
        if (!(messageTypeCase_ == 1)) {
          messageType_ = net.heydel.protobuf.ChatMessage.getDefaultInstance();
        }
        chatMessageBuilder_ = new com.google.protobuf.SingleFieldBuilder<
            net.heydel.protobuf.ChatMessage, net.heydel.protobuf.ChatMessage.Builder, net.heydel.protobuf.ChatMessageOrBuilder>(
                (net.heydel.protobuf.ChatMessage) messageType_,
                getParentForChildren(),
                isClean());
        messageType_ = null;
      }
      messageTypeCase_ = 1;
      onChanged();
      return chatMessageBuilder_;
    }

    private com.google.protobuf.SingleFieldBuilder<
        net.heydel.protobuf.LoginMessage, net.heydel.protobuf.LoginMessage.Builder, net.heydel.protobuf.LoginMessageOrBuilder> loginMessageBuilder_;
    /**
     * <code>.pv_teil_2.LoginMessage login_message = 2;</code>
     * @return Whether the loginMessage field is set.
     */
    @java.lang.Override
    public boolean hasLoginMessage() {
      return messageTypeCase_ == 2;
    }
    /**
     * <code>.pv_teil_2.LoginMessage login_message = 2;</code>
     * @return The loginMessage.
     */
    @java.lang.Override
    public net.heydel.protobuf.LoginMessage getLoginMessage() {
      if (loginMessageBuilder_ == null) {
        if (messageTypeCase_ == 2) {
          return (net.heydel.protobuf.LoginMessage) messageType_;
        }
        return net.heydel.protobuf.LoginMessage.getDefaultInstance();
      } else {
        if (messageTypeCase_ == 2) {
          return loginMessageBuilder_.getMessage();
        }
        return net.heydel.protobuf.LoginMessage.getDefaultInstance();
      }
    }
    /**
     * <code>.pv_teil_2.LoginMessage login_message = 2;</code>
     */
    public Builder setLoginMessage(net.heydel.protobuf.LoginMessage value) {
      if (loginMessageBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        messageType_ = value;
        onChanged();
      } else {
        loginMessageBuilder_.setMessage(value);
      }
      messageTypeCase_ = 2;
      return this;
    }
    /**
     * <code>.pv_teil_2.LoginMessage login_message = 2;</code>
     */
    public Builder setLoginMessage(
        net.heydel.protobuf.LoginMessage.Builder builderForValue) {
      if (loginMessageBuilder_ == null) {
        messageType_ = builderForValue.build();
        onChanged();
      } else {
        loginMessageBuilder_.setMessage(builderForValue.build());
      }
      messageTypeCase_ = 2;
      return this;
    }
    /**
     * <code>.pv_teil_2.LoginMessage login_message = 2;</code>
     */
    public Builder mergeLoginMessage(net.heydel.protobuf.LoginMessage value) {
      if (loginMessageBuilder_ == null) {
        if (messageTypeCase_ == 2 &&
            messageType_ != net.heydel.protobuf.LoginMessage.getDefaultInstance()) {
          messageType_ = net.heydel.protobuf.LoginMessage.newBuilder((net.heydel.protobuf.LoginMessage) messageType_)
              .mergeFrom(value).buildPartial();
        } else {
          messageType_ = value;
        }
        onChanged();
      } else {
        if (messageTypeCase_ == 2) {
          loginMessageBuilder_.mergeFrom(value);
        } else {
          loginMessageBuilder_.setMessage(value);
        }
      }
      messageTypeCase_ = 2;
      return this;
    }
    /**
     * <code>.pv_teil_2.LoginMessage login_message = 2;</code>
     */
    public Builder clearLoginMessage() {
      if (loginMessageBuilder_ == null) {
        if (messageTypeCase_ == 2) {
          messageTypeCase_ = 0;
          messageType_ = null;
          onChanged();
        }
      } else {
        if (messageTypeCase_ == 2) {
          messageTypeCase_ = 0;
          messageType_ = null;
        }
        loginMessageBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>.pv_teil_2.LoginMessage login_message = 2;</code>
     */
    public net.heydel.protobuf.LoginMessage.Builder getLoginMessageBuilder() {
      return getLoginMessageFieldBuilder().getBuilder();
    }
    /**
     * <code>.pv_teil_2.LoginMessage login_message = 2;</code>
     */
    @java.lang.Override
    public net.heydel.protobuf.LoginMessageOrBuilder getLoginMessageOrBuilder() {
      if ((messageTypeCase_ == 2) && (loginMessageBuilder_ != null)) {
        return loginMessageBuilder_.getMessageOrBuilder();
      } else {
        if (messageTypeCase_ == 2) {
          return (net.heydel.protobuf.LoginMessage) messageType_;
        }
        return net.heydel.protobuf.LoginMessage.getDefaultInstance();
      }
    }
    /**
     * <code>.pv_teil_2.LoginMessage login_message = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilder<
        net.heydel.protobuf.LoginMessage, net.heydel.protobuf.LoginMessage.Builder, net.heydel.protobuf.LoginMessageOrBuilder> 
        getLoginMessageFieldBuilder() {
      if (loginMessageBuilder_ == null) {
        if (!(messageTypeCase_ == 2)) {
          messageType_ = net.heydel.protobuf.LoginMessage.getDefaultInstance();
        }
        loginMessageBuilder_ = new com.google.protobuf.SingleFieldBuilder<
            net.heydel.protobuf.LoginMessage, net.heydel.protobuf.LoginMessage.Builder, net.heydel.protobuf.LoginMessageOrBuilder>(
                (net.heydel.protobuf.LoginMessage) messageType_,
                getParentForChildren(),
                isClean());
        messageType_ = null;
      }
      messageTypeCase_ = 2;
      onChanged();
      return loginMessageBuilder_;
    }

    private com.google.protobuf.SingleFieldBuilder<
        net.heydel.protobuf.CodeMessage, net.heydel.protobuf.CodeMessage.Builder, net.heydel.protobuf.CodeMessageOrBuilder> codeMessageBuilder_;
    /**
     * <code>.pv_teil_2.CodeMessage code_message = 3;</code>
     * @return Whether the codeMessage field is set.
     */
    @java.lang.Override
    public boolean hasCodeMessage() {
      return messageTypeCase_ == 3;
    }
    /**
     * <code>.pv_teil_2.CodeMessage code_message = 3;</code>
     * @return The codeMessage.
     */
    @java.lang.Override
    public net.heydel.protobuf.CodeMessage getCodeMessage() {
      if (codeMessageBuilder_ == null) {
        if (messageTypeCase_ == 3) {
          return (net.heydel.protobuf.CodeMessage) messageType_;
        }
        return net.heydel.protobuf.CodeMessage.getDefaultInstance();
      } else {
        if (messageTypeCase_ == 3) {
          return codeMessageBuilder_.getMessage();
        }
        return net.heydel.protobuf.CodeMessage.getDefaultInstance();
      }
    }
    /**
     * <code>.pv_teil_2.CodeMessage code_message = 3;</code>
     */
    public Builder setCodeMessage(net.heydel.protobuf.CodeMessage value) {
      if (codeMessageBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        messageType_ = value;
        onChanged();
      } else {
        codeMessageBuilder_.setMessage(value);
      }
      messageTypeCase_ = 3;
      return this;
    }
    /**
     * <code>.pv_teil_2.CodeMessage code_message = 3;</code>
     */
    public Builder setCodeMessage(
        net.heydel.protobuf.CodeMessage.Builder builderForValue) {
      if (codeMessageBuilder_ == null) {
        messageType_ = builderForValue.build();
        onChanged();
      } else {
        codeMessageBuilder_.setMessage(builderForValue.build());
      }
      messageTypeCase_ = 3;
      return this;
    }
    /**
     * <code>.pv_teil_2.CodeMessage code_message = 3;</code>
     */
    public Builder mergeCodeMessage(net.heydel.protobuf.CodeMessage value) {
      if (codeMessageBuilder_ == null) {
        if (messageTypeCase_ == 3 &&
            messageType_ != net.heydel.protobuf.CodeMessage.getDefaultInstance()) {
          messageType_ = net.heydel.protobuf.CodeMessage.newBuilder((net.heydel.protobuf.CodeMessage) messageType_)
              .mergeFrom(value).buildPartial();
        } else {
          messageType_ = value;
        }
        onChanged();
      } else {
        if (messageTypeCase_ == 3) {
          codeMessageBuilder_.mergeFrom(value);
        } else {
          codeMessageBuilder_.setMessage(value);
        }
      }
      messageTypeCase_ = 3;
      return this;
    }
    /**
     * <code>.pv_teil_2.CodeMessage code_message = 3;</code>
     */
    public Builder clearCodeMessage() {
      if (codeMessageBuilder_ == null) {
        if (messageTypeCase_ == 3) {
          messageTypeCase_ = 0;
          messageType_ = null;
          onChanged();
        }
      } else {
        if (messageTypeCase_ == 3) {
          messageTypeCase_ = 0;
          messageType_ = null;
        }
        codeMessageBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>.pv_teil_2.CodeMessage code_message = 3;</code>
     */
    public net.heydel.protobuf.CodeMessage.Builder getCodeMessageBuilder() {
      return getCodeMessageFieldBuilder().getBuilder();
    }
    /**
     * <code>.pv_teil_2.CodeMessage code_message = 3;</code>
     */
    @java.lang.Override
    public net.heydel.protobuf.CodeMessageOrBuilder getCodeMessageOrBuilder() {
      if ((messageTypeCase_ == 3) && (codeMessageBuilder_ != null)) {
        return codeMessageBuilder_.getMessageOrBuilder();
      } else {
        if (messageTypeCase_ == 3) {
          return (net.heydel.protobuf.CodeMessage) messageType_;
        }
        return net.heydel.protobuf.CodeMessage.getDefaultInstance();
      }
    }
    /**
     * <code>.pv_teil_2.CodeMessage code_message = 3;</code>
     */
    private com.google.protobuf.SingleFieldBuilder<
        net.heydel.protobuf.CodeMessage, net.heydel.protobuf.CodeMessage.Builder, net.heydel.protobuf.CodeMessageOrBuilder> 
        getCodeMessageFieldBuilder() {
      if (codeMessageBuilder_ == null) {
        if (!(messageTypeCase_ == 3)) {
          messageType_ = net.heydel.protobuf.CodeMessage.getDefaultInstance();
        }
        codeMessageBuilder_ = new com.google.protobuf.SingleFieldBuilder<
            net.heydel.protobuf.CodeMessage, net.heydel.protobuf.CodeMessage.Builder, net.heydel.protobuf.CodeMessageOrBuilder>(
                (net.heydel.protobuf.CodeMessage) messageType_,
                getParentForChildren(),
                isClean());
        messageType_ = null;
      }
      messageTypeCase_ = 3;
      onChanged();
      return codeMessageBuilder_;
    }

    // @@protoc_insertion_point(builder_scope:pv_teil_2.MessageWrapper)
  }

  // @@protoc_insertion_point(class_scope:pv_teil_2.MessageWrapper)
  private static final net.heydel.protobuf.MessageWrapper DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new net.heydel.protobuf.MessageWrapper();
  }

  public static net.heydel.protobuf.MessageWrapper getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<MessageWrapper>
      PARSER = new com.google.protobuf.AbstractParser<MessageWrapper>() {
    @java.lang.Override
    public MessageWrapper parsePartialFrom(
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

  public static com.google.protobuf.Parser<MessageWrapper> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<MessageWrapper> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public net.heydel.protobuf.MessageWrapper getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
