package com.main.webapplication.exception;


public abstract class RestException extends RuntimeException {

    RestException(String errorMessage) {
        super(errorMessage);
    }

}
