package com.webapplication.service.user;


import com.webapplication.dto.user.*;
import com.webapplication.exception.RestException;

public interface UserServiceApi {

    UserRegisterResponseDto register(UserRegisterRequestDto userRegisterRequestDto) throws RestException;

    UserLogInResponseDto login(UserLogInRequestDto userLogInRequestDto) throws RestException;

    public UserProfileDto getProfile(UserUtilsDto userUtilsDto);

    public UserProfileDto updateProfile(UserUpdateProfileDto userUpdateProfileDto);

}
