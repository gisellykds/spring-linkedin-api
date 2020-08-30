package com.api.linkedin.utils.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ApiLinkedinException extends ResponseStatusException {

    @Getter
    private String message;

    public ApiLinkedinException(HttpStatus status, String message) {
        super(status, (String)null, (Throwable)null);
        this.message = message;
    }

}
