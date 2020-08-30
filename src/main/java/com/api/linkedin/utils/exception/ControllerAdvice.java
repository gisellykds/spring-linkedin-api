package com.api.linkedin.utils.exception;

import com.api.linkedin.utils.exception.response.ApiLinkedinException;
import com.api.linkedin.utils.exception.response.ResponseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import springfox.documentation.annotations.ApiIgnore;
import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(ApiLinkedinException.class)
    public ResponseEntity<ResponseException> ApiLinkedinException(HttpServletRequest request, ApiLinkedinException exception) {
        return new ResponseEntity<>(new ResponseException(request, exception), exception.getStatus());
    }

}
