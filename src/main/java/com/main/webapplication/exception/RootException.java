package com.main.webapplication.exception;


public abstract class RootException extends Exception {

    RootException(String errorMessage) {
        super(errorMessage);
    }

}
