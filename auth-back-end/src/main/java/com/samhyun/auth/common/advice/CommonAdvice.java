package com.samhyun.auth.common.advice;

import com.samhyun.auth.common.exception.InvalidDataException;
import com.samhyun.auth.common.exception.InvalidDataExceptionStatus;
import com.samhyun.auth.common.exception.RestfulException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class CommonAdvice {

    private static final int INVALID_DATA_FORMAT_CODE = 244;

    @ExceptionHandler(RestfulException.class)
    public RestfulException handleRestfulException(RestfulException exception, HttpServletResponse response) {
        response.setStatus(exception.getHttpStatus().value());
        return exception;
    }

    @ExceptionHandler(InvalidDataException.class)
    public InvalidDataExceptionStatus handleInvalidDataException(InvalidDataException exception, HttpServletResponse response) {
        response.setStatus(INVALID_DATA_FORMAT_CODE);
        return exception.getStatus();
    }
}
