package net.heydel.model;

import net.heydel.protobuf.CodeMessage;
import net.heydel.protobuf.MessageWrapper;

public class CodeMessageCreater {
    public static final int LOGIN_FAILED = 1;
    public static final int LOGIN_SUCCESS = 2;
    public static final int USER_NOT_FOUND = 10;
    public static final int USER_NOT_ONLINE = 11;

    public static final int SERVER_ERROR = 400;
    
    public static MessageWrapper createCodeMessage(int code) {
        return MessageWrapper.newBuilder().setCodeMessage(CodeMessage.newBuilder().setCode(code).build()).build();
    }
}
