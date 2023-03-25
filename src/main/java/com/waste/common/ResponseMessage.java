package com.waste.common;

import org.springframework.http.HttpStatus;

public class ResponseMessage<T> {
    private int statusCode = HttpStatus.OK.value();
    private String message = "";
    protected T data;

    public static ResponseMessage<String> ok() {
        return new ResponseMessage<>("");
    }

    public static <T> ResponseMessage<T> ok(T data) {
        return new ResponseMessage<>(data);
    }
    public static ResponseMessage<String> badRequest(String message) {
        return new ResponseMessage<>(HttpStatus.BAD_REQUEST.value(), message, "");
    }
    private ResponseMessage(T data) {
        this.data = data;
    }

    private ResponseMessage(int statusCode, String message, T data) {
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}
