package com.webapplication.rest.user;


import com.webapplication.dto.user.*;
<<<<<<< HEAD
import com.webapplication.entity.ResidenceEntity;
=======
import com.webapplication.entity.UserEntity;
>>>>>>> 399052ab6f5c54ce43f4ea0e085a17dc737fff6c
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
import java.util.List;

@Component
public class UserApiImpl implements UserApi {

    @Autowired
    private UserServiceApi userServiceApi;

    @Override
    public UserEntity register(@RequestBody UserRegisterRequestDto userRegisterRequestDto) throws RestException {
        return userServiceApi.register(userRegisterRequestDto);
    }

    @Override
    public UserEntity login(@RequestBody UserLogInRequestDto userLogInRequestDto) throws RestException {
        return userServiceApi.login(userLogInRequestDto);
    }

    @Override
    public UserEntity getProfile(@RequestBody  UserUtilsDto userUtilsDto) throws RestException {
        return userServiceApi.getProfile(userUtilsDto);
    }

    @Override
<<<<<<< HEAD
    public List<ResidenceEntity> getUserResidences(UserUtilsDto userUtilsDto) throws RestException {
        return userServiceApi.getResidences(userUtilsDto);
=======
    public UserEntity updateProfile(@RequestBody  UserUpdateProfileDto userUpdateProfileDto) throws RestException {
        return userServiceApi.updateProfile(userUpdateProfileDto);
>>>>>>> 399052ab6f5c54ce43f4ea0e085a17dc737fff6c
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
