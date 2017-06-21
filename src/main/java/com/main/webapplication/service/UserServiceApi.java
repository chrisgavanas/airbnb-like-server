package com.main.webapplication.service;


import com.main.webapplication.dto.user.UserLogInRequestDto;
import com.main.webapplication.dto.user.UserLogInResponsetDto;
import com.main.webapplication.dto.user.UserRegisterRequestDto;
import com.main.webapplication.dto.user.UserRegisterResponseDto;
import com.main.webapplication.exception.RestException;

public interface UserServiceApi {

    UserRegisterResponseDto register(UserRegisterRequestDto userRegisterRequestDto) throws RestException;

    UserLogInResponsetDto login(UserLogInRequestDto userLogInRequestDto) throws RestException;

}
