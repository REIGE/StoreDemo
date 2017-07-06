package com.reige.storedemo.exception;

/**
 * Created by REIGE on 2017/7/6.
 */
public class RegistException extends Exception {
    public RegistException() {
        super();
    }

    public RegistException(String message) {
        super(message);
    }

    public RegistException(String message, Throwable cause) {
        super(message, cause);
    }

    public RegistException(Throwable cause) {
        super(cause);
    }
}
