package com.main.webapplication.exception;


import com.main.webapplication.error.UserError;

public class UserAlreadyExistsException extends RootException {

    public UserAlreadyExistsException(UserError userError) {
        super(userError.getDescription());
    }
}
