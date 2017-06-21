package com.main.webapplication.exception;


import com.main.webapplication.error.UserError;

public class AuthenticationException extends RestException {

    public AuthenticationException(UserError userError) {
        super(userError.getDescription());
    }
}
