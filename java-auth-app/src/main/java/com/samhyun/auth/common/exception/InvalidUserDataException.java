package com.samhyun.auth.common.exception;

public class InvalidUserDataException extends InvalidDataException {

    public InvalidUserDataException(InvalidDataExceptionStatus status) {
        super(status);
    }
}
