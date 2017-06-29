package com.webapplication.mapper;

import com.webapplication.dto.user.UserLogInResponsetDto;
import com.webapplication.dto.user.UserRegisterRequestDto;
import com.webapplication.dto.user.UserRegisterResponseDto;
import com.webapplication.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserMapper {

    public UserEntity toUserEntity(UserRegisterRequestDto userRegisterRequestDto, String encodedSalt, String encodedPassword) {
        if (userRegisterRequestDto == null) {
            return null;
        }

        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userRegisterRequestDto.getUsername());
        userEntity.setPassword(encodedPassword);
        userEntity.setName(userRegisterRequestDto.getName());
        userEntity.setSurname(userRegisterRequestDto.getSurname());
        userEntity.setEmail(userRegisterRequestDto.getEmail());
        userEntity.setPhoneNumber(userRegisterRequestDto.getPhoneNumber());
        userEntity.setSalt(encodedSalt);
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

    public UserLogInResponsetDto toUserLogInResponseDto(String username, UUID authToken) {
        UserLogInResponsetDto userLogInResponsetDto = new UserLogInResponsetDto();
        userLogInResponsetDto.setUsername(username);
        userLogInResponsetDto.setAuthToken(authToken);
        return userLogInResponsetDto;
    }

}
