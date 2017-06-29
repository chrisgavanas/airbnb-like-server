package com.webapplication.service;

import com.webapplication.authentication.Authenticator;
import com.webapplication.dao.UserRepository;
import com.webapplication.dto.user.SessionInfo;
import com.webapplication.dto.user.UserLogInRequestDto;
import com.webapplication.dto.user.UserLogInResponsetDto;
import com.webapplication.dto.user.UserRegisterRequestDto;
import com.webapplication.dto.user.UserRegisterResponseDto;
import com.webapplication.entity.UserEntity;
import com.webapplication.error.UserError;
import com.webapplication.exception.AuthenticationException;
import com.webapplication.exception.RestException;
import com.webapplication.exception.UserAlreadyExistsException;
import com.webapplication.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Clock;
import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Transactional
@Service
public class UserServiceApiImpl implements UserServiceApi {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Authenticator authenticator;

    @Autowired
    private Clock clock;

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
        SessionInfo sessionInfo = new SessionInfo(user.getUserId(), LocalDate.now(clock));
        UUID authToken = authenticator.createSession(sessionInfo);
        return userMapper.toUserLogInResponseDto(userLogInRequestDto, authToken);
    }

}
