package com.project.developer.cpa.exception;

public class CpaInternalException extends RuntimeException {

    public CpaInternalException(String message) {
        super(message);
    }

    public CpaInternalException(String message, Throwable cause) {
        super(message, cause);

    }
}
