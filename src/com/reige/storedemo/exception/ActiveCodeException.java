package com.reige.storedemo.exception;

/**
 * Created by REIGE on 2017/7/6.
 */
public class ActiveCodeException extends RuntimeException {

    public ActiveCodeException() {
        super();
    }

    public ActiveCodeException(String message) {
        super(message);
    }

    public ActiveCodeException(String message, Throwable cause) {
        super(message, cause);
    }

    public ActiveCodeException(Throwable cause) {
        super(cause);
    }
}
