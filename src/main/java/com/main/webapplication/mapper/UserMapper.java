package com.main.webapplication.mapper;

import com.main.webapplication.dto.user.UserLogInRequestDto;
import com.main.webapplication.dto.user.UserLogInResponsetDto;
import com.main.webapplication.dto.user.UserRegisterRequestDto;
import com.main.webapplication.dto.user.UserRegisterResponseDto;
import com.main.webapplication.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserEntity toUserEntity(UserRegisterRequestDto userRegisterRequestDto) {
        if (userRegisterRequestDto == null) {
            return null;
        }

        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userRegisterRequestDto.getUsername());
        userEntity.setPassword(userRegisterRequestDto.getPassword());
        userEntity.setName(userRegisterRequestDto.getName());
        userEntity.setSurname(userRegisterRequestDto.getSurname());
        userEntity.setEmail(userRegisterRequestDto.getEmail());
        userEntity.setPhoneNumber(userRegisterRequestDto.getPhoneNumber());
        return userEntity;
    }

    public UserRegisterResponseDto toUserRegisterResponseDto(UserEntity userEntity) {
        if (userEntity == null) {
            return null;
        }

        UserRegisterResponseDto userRegisterResponseDto = new UserRegisterResponseDto();
        userRegisterResponseDto.setUserId(userEntity.getUserId());
        userRegisterResponseDto.setUsername(userEntity.getUsername());
        userRegisterResponseDto.setPassword(userEntity.getPassword());
        userRegisterResponseDto.setName(userEntity.getName());
        userRegisterResponseDto.setSurname(userEntity.getSurname());
        userRegisterResponseDto.setEmail(userEntity.getEmail());
        userRegisterResponseDto.setPhoneNumber(userEntity.getPhoneNumber());
        return userRegisterResponseDto;
    }

    public UserLogInResponsetDto toUserLogInResponseDto(UserLogInRequestDto userLogInRequestDto, String authToken) {
        if (userLogInRequestDto == null) {
            return null;
        }

        UserLogInResponsetDto userLogInResponsetDto = new UserLogInResponsetDto();
        userLogInResponsetDto.setAuthToken(authToken);
        return userLogInResponsetDto;
    }

}
