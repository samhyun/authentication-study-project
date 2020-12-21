package com.samhyun.auth.common.exception;

import lombok.Getter;

public class InvalidDataException extends RuntimeException {

    @Getter
    private final InvalidDataExceptionStatus status;

    public InvalidDataException(InvalidDataExceptionStatus status) {
        this.status = status;
    }
}
