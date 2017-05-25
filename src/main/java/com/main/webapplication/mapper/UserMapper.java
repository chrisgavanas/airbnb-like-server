package com.main.webapplication.mapper;

import com.main.webapplication.dto.UserRegisterRequestDto;
import com.main.webapplication.dto.UserRegisterResponseDto;
import com.main.webapplication.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserEntity convertUserRegisterRequestDtoToUserEntity(UserRegisterRequestDto userRegisterRequestDto) {
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

    public UserRegisterResponseDto convertUserEntityToUserRegisterResponseDto(UserEntity userEntity) {
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

}
