package com.main.webapplication.rest;


import com.main.webapplication.dto.UserRegisterRequestDto;
import com.main.webapplication.dto.UserRegisterResponseDto;
import com.main.webapplication.exception.UserAlreadyExistsException;
import com.main.webapplication.service.UserServiceApi;
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
    public UserRegisterResponseDto register(@RequestBody UserRegisterRequestDto userRegisterRequestDto) throws Exception {
        return userServiceApi.register(userRegisterRequestDto);
    }

    @ExceptionHandler({UserAlreadyExistsException.class})
    private void conflict(Exception e, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.CONFLICT.value());
    }

}
