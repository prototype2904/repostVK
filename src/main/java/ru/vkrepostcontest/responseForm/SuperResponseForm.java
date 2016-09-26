package ru.vkrepostcontest.responseForm;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Stetskevich Roman on 06.09.2016.
 * @since 0.1
 */
public class SuperResponseForm<T> {

    @JsonProperty("response")
    private T response;

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }
}
