package com.main.webapplication.service;

import com.main.webapplication.dao.UserRepository;
import com.main.webapplication.dto.user.UserLogInRequestDto;
import com.main.webapplication.dto.user.UserLogInResponsetDto;
import com.main.webapplication.dto.user.UserRegisterRequestDto;
import com.main.webapplication.dto.user.UserRegisterResponseDto;
import com.main.webapplication.entity.UserEntity;
import com.main.webapplication.error.UserError;
import com.main.webapplication.exception.AuthenticationException;
import com.main.webapplication.exception.RestException;
import com.main.webapplication.exception.UserAlreadyExistsException;
import com.main.webapplication.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Transactional
@Service
public class UserServiceApiImpl implements UserServiceApi {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private Authenticator authenticator;

    @Override
    public UserRegisterResponseDto register(UserRegisterRequestDto userRegisterRequestDto) throws RestException {
        UserEntity userEntity = userRepository.findUserEntityByUsername(userRegisterRequestDto.getUsername());
        if (userEntity != null) {
            throw new UserAlreadyExistsException(UserError.USERNAME_ALREADY_EXISTS);
        }
        userEntity = userMapper.toUserEntity(userRegisterRequestDto);
        userRepository.save(userEntity);
        return userMapper.toUserRegisterResponseDto(userEntity);
    }

    @Override
    public UserLogInResponsetDto login(UserLogInRequestDto userLogInRequestDto) throws RestException {
        UserEntity user = userRepository.findUserEntityByUsernameAndPassword(userLogInRequestDto.getUsername(), userLogInRequestDto.getPassword());
        Optional.ofNullable(user).orElseThrow(() -> new AuthenticationException(UserError.INVALID_CREDENTIALS));
//        SessionInfo sessionInfo = new SessionInfo(user.getUserId(), DateTime.now());
//        UUID authToken = authenticator.createSession(sessionInfo);

        return userMapper.toUserLogInResponseDto(userLogInRequestDto, "Hello");
    }

}
