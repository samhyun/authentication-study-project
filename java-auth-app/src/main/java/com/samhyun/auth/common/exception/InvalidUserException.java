package com.samhyun.auth.common.exception;

public class InvalidUserException extends Throwable {
    public InvalidUserException() {
        super("Invalid User Data");
    }
}
