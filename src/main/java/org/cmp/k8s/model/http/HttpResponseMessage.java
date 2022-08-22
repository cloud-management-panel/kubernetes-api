package org.cmp.k8s.model.http;

public class HttpResponseMessage {

    private String code;
    private final String message;
    private final MessageType messageType;

    public HttpResponseMessage(String message, MessageType messageType) {
        this.message = message;
        this.messageType = messageType;
    }

    public HttpResponseMessage(String code, String message, MessageType messageType) {
        this.code = code;
        this.message = message;
        this.messageType = messageType;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public enum MessageType{
        INFO,
        WARNING,
        ERROR
    }
}
