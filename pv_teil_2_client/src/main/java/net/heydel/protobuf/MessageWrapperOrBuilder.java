// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: test.proto
// Protobuf Java Version: 4.27.1

package net.heydel.protobuf;

public interface MessageWrapperOrBuilder extends
    // @@protoc_insertion_point(interface_extends:pv_teil_2.MessageWrapper)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.pv_teil_2.ChatMessage chat_message = 1;</code>
   * @return Whether the chatMessage field is set.
   */
  boolean hasChatMessage();
  /**
   * <code>.pv_teil_2.ChatMessage chat_message = 1;</code>
   * @return The chatMessage.
   */
  net.heydel.protobuf.ChatMessage getChatMessage();
  /**
   * <code>.pv_teil_2.ChatMessage chat_message = 1;</code>
   */
  net.heydel.protobuf.ChatMessageOrBuilder getChatMessageOrBuilder();

  /**
   * <code>.pv_teil_2.LoginMessage login_message = 2;</code>
   * @return Whether the loginMessage field is set.
   */
  boolean hasLoginMessage();
  /**
   * <code>.pv_teil_2.LoginMessage login_message = 2;</code>
   * @return The loginMessage.
   */
  net.heydel.protobuf.LoginMessage getLoginMessage();
  /**
   * <code>.pv_teil_2.LoginMessage login_message = 2;</code>
   */
  net.heydel.protobuf.LoginMessageOrBuilder getLoginMessageOrBuilder();

  /**
   * <code>.pv_teil_2.CodeMessage code_message = 3;</code>
   * @return Whether the codeMessage field is set.
   */
  boolean hasCodeMessage();
  /**
   * <code>.pv_teil_2.CodeMessage code_message = 3;</code>
   * @return The codeMessage.
   */
  net.heydel.protobuf.CodeMessage getCodeMessage();
  /**
   * <code>.pv_teil_2.CodeMessage code_message = 3;</code>
   */
  net.heydel.protobuf.CodeMessageOrBuilder getCodeMessageOrBuilder();

  net.heydel.protobuf.MessageWrapper.MessageTypeCase getMessageTypeCase();
}
