package com.mindcraft.exception;

import org.springframework.http.HttpStatus;

public class BaseException extends RuntimeException {

    private final HttpStatus status;
    private final String errorCode;


    public BaseException(String errorCode, String message, HttpStatus status) {
        super(message);
        this.status = status;
        this.errorCode = errorCode;
    }

    public BaseException(String message) {
        super(message);
        this.status = HttpStatus.BAD_REQUEST;
        this.errorCode = "GEN_400";
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
