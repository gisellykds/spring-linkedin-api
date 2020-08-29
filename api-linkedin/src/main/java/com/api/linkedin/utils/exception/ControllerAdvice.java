package com.api.linkedin.utils.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(ApiLinkedinException.class)
    ResponseException ApiLinkedinException(HttpServletRequest request, ApiLinkedinException exception) {
        return new ResponseException(request, exception);
    }

}
