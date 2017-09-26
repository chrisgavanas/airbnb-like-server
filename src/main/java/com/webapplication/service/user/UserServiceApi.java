package com.webapplication.service.user;


import com.webapplication.dto.user.*;
import com.webapplication.entity.ResidenceEntity;
import com.webapplication.exception.RestException;

import java.util.List;

public interface UserServiceApi {

    UserRegisterResponseDto register(UserRegisterRequestDto userRegisterRequestDto) throws RestException;

    UserLogInResponseDto login(UserLogInRequestDto userLogInRequestDto) throws RestException;

    public UserProfileDto getProfile(UserUtilsDto userUtilsDto);

    List<ResidenceEntity> getResidences(UserUtilsDto userUtilsDto);
}
