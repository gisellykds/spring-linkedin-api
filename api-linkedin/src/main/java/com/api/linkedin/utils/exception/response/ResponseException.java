package com.api.linkedin.utils.exception.response;

import lombok.Getter;
import javax.servlet.http.HttpServletRequest;

@Getter
public class ResponseException {
    public final String path;
    public final String message;

    public ResponseException(HttpServletRequest path, RuntimeException ex) {
        this.path = path.getRequestURI();
        this.message = ex.getLocalizedMessage();
    }
}
