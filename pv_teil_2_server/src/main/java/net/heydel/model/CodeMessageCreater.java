package net.heydel.model;

import net.heydel.protobuf.CodeMessage;
import net.heydel.protobuf.MessageWrapper;

public class CodeMessageCreater {
    public static final int LOGIN_FAILED = 1;
    public static final int LOGIN_SUCCESS = 2;
    public static final int USER_NOT_FOUND = 10;
    public static final int USER_NOT_ONLINE = 11;
    
    public static MessageWrapper createCodeMessage(int code) {
        switch (code) {
            case LOGIN_FAILED:
                return loginFailed();
            case LOGIN_SUCCESS:
                return loginSuccess();
            default:
                return null;
        }
    }

    private static MessageWrapper loginSuccess() {
        CodeMessage codeMessage = CodeMessage.newBuilder().setCode(LOGIN_SUCCESS).build();
        return MessageWrapper.newBuilder().setCodeMessage(codeMessage).build();
    }

    private static MessageWrapper loginFailed() {
        CodeMessage codeMessage = CodeMessage.newBuilder().setCode(LOGIN_FAILED).build();
        return MessageWrapper.newBuilder().setCodeMessage(codeMessage).build();
    }
}
