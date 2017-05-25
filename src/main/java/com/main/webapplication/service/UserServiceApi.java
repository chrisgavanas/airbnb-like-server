package com.main.webapplication.service;


import com.main.webapplication.dto.UserRegisterRequestDto;
import com.main.webapplication.dto.UserRegisterResponseDto;

public interface UserServiceApi {

    UserRegisterResponseDto register(UserRegisterRequestDto userRegisterRequestDto) throws Exception;

}
