package com.samhyun.auth.common.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public abstract class RestfulException extends RuntimeException {

    @Getter
    private final String exceptionMessage;

    @Getter
    private final HttpStatus httpStatus;

    public RestfulException(String exceptionMessage, HttpStatus httpStatus) {
        this.exceptionMessage = exceptionMessage;
        this.httpStatus = httpStatus;
    }
}
