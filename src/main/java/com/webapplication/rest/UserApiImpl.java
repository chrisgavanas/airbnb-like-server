package com.webapplication.rest;


import com.webapplication.dto.user.UserLogInRequestDto;
import com.webapplication.dto.user.UserLogInResponsetDto;
import com.webapplication.dto.user.UserRegisterRequestDto;
import com.webapplication.dto.user.UserRegisterResponseDto;
import com.webapplication.exception.AuthenticationException;
import com.webapplication.exception.ConfigurationException;
import com.webapplication.exception.RestException;
import com.webapplication.exception.UserAlreadyExistsException;
import com.webapplication.service.UserServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class UserApiImpl implements UserApi {

    @Autowired
    private UserServiceApi userServiceApi;

    @Override
    public UserRegisterResponseDto register(@RequestBody UserRegisterRequestDto userRegisterRequestDto) throws RestException {
        return userServiceApi.register(userRegisterRequestDto);
    }

    @Override
    public UserLogInResponsetDto login(@RequestBody UserLogInRequestDto userLogInRequestDto) throws RestException {
        return userServiceApi.login(userLogInRequestDto);
    }

    @ExceptionHandler({UserAlreadyExistsException.class, ConfigurationException.class})
    private void conflict(UserAlreadyExistsException e, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.CONFLICT.value());
    }

    @ExceptionHandler({AuthenticationException.class})
    private void authentication(AuthenticationException e, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.UNAUTHORIZED.value());
    }

    @ExceptionHandler({RestException.class})
    private void generic(RestException e, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

}
