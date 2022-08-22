package org.cmp.k8s.model.http;

import java.util.Collections;
import java.util.Set;

public class HttpResponseBody<T> {
    private final T data;
    private final Boolean hasError;
    private final Set<HttpResponseMessage> messages;

    private HttpResponseBody(T data) {
        this.data = data;
        this.hasError = false;
        this.messages = Collections.emptySet();
    }

    private HttpResponseBody(Set<HttpResponseMessage> responseMessages) {
        this.data = null;
        this.messages = responseMessages;
        this.hasError = messages.stream().anyMatch(m -> HttpResponseMessage.MessageType.ERROR.equals(m.getMessageType()));
    }

    public static <E> HttpResponseBody<E> success(E data) {
        return new HttpResponseBody<>(data);
    }

    public static HttpResponseBody<Void> error(String error) {
        return new HttpResponseBody<>(Collections.singleton(new HttpResponseMessage(error, HttpResponseMessage.MessageType.ERROR)));
    }

    public T getData() {
        return data;
    }

    public Boolean getHasError() {
        return hasError;
    }

    public Set<HttpResponseMessage> getMessages() {
        return messages;
    }

}
