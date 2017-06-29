package com.webapplication.service;


import com.webapplication.dto.user.UserLogInRequestDto;
import com.webapplication.dto.user.UserLogInResponsetDto;
import com.webapplication.dto.user.UserRegisterRequestDto;
import com.webapplication.dto.user.UserRegisterResponseDto;
import com.webapplication.exception.RestException;

public interface UserServiceApi {

    UserRegisterResponseDto register(UserRegisterRequestDto userRegisterRequestDto) throws RestException;

    UserLogInResponsetDto login(UserLogInRequestDto userLogInRequestDto) throws RestException;

}
