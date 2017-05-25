package com.main.webapplication.service;

import com.main.webapplication.dao.UserRepository;
import com.main.webapplication.dto.UserRegisterRequestDto;
import com.main.webapplication.dto.UserRegisterResponseDto;
import com.main.webapplication.entity.UserEntity;
import com.main.webapplication.error.UserError;
import com.main.webapplication.exception.UserAlreadyExistsException;
import com.main.webapplication.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceApiImpl implements UserServiceApi {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserRegisterResponseDto register(UserRegisterRequestDto userRegisterRequestDto) throws Exception {
        UserEntity userEntity = userRepository.findUserEntityByUsername(userRegisterRequestDto.getUsername());
        if (userEntity != null) {
            throw new UserAlreadyExistsException(UserError.USERNAME_ALREADY_EXISTS);
        }
        userEntity = userMapper.convertUserRegisterRequestDtoToUserEntity(userRegisterRequestDto);
        userRepository.save(userEntity);
        return userMapper.convertUserEntityToUserRegisterResponseDto(userEntity);
    }

}
