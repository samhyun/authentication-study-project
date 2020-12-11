package com.samhyun.auth.common.advice;

import com.samhyun.auth.common.exception.InvalidUserException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class CommonAdvice {

    @ExceptionHandler(InvalidUserException.class)
    public String handleInvalidUserException(InvalidUserException exception, HttpServletResponse response) {
        response.setStatus(HttpStatus.NO_CONTENT.value());
        return exception.getClass().getSimpleName();
    }
}
