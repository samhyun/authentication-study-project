package com.samhyun.auth.common.exception;

import lombok.Getter;

public abstract class InvalidDataException extends RuntimeException {

    @Getter
    private InvalidDataExceptionStatus status;

    public InvalidDataException(InvalidDataExceptionStatus status) {
        this.status = status;
    }
}
