package com.start.exception;

public class PasswordException extends RuntimeException {
    public PasswordException() {
        super();
    }
    public PasswordException(String message, Throwable cause) {
        super(message, cause);
    }
    public PasswordException(String message) {
        super(message);
    }
    public PasswordException(Throwable cause) {
        super(cause);
    }
}
