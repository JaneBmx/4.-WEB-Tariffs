package com.vlasova.exception;

public class UnknownParseTypeException extends Exception {
    public UnknownParseTypeException() {
    }

    public UnknownParseTypeException(String message) {
        super(message);
    }

    public UnknownParseTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnknownParseTypeException(Throwable cause) {
        super(cause);
    }

    public UnknownParseTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
