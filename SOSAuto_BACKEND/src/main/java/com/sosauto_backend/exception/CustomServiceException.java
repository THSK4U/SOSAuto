package com.sosauto_backend.exception;

public class CustomServiceException extends RuntimeException {
    public CustomServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
