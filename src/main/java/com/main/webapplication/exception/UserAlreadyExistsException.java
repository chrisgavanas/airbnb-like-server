package com.main.webapplication.exception;


import com.main.webapplication.error.UserError;

public class UserAlreadyExistsException extends RestException {

    public UserAlreadyExistsException(UserError userError) {
        super(userError.getDescription());
    }
}
