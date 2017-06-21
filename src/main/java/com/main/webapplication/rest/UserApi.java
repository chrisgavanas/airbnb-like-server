package com.main.webapplication.rest;

import com.main.webapplication.dto.user.UserLogInRequestDto;
import com.main.webapplication.dto.user.UserLogInResponsetDto;
import com.main.webapplication.dto.user.UserRegisterRequestDto;
import com.main.webapplication.dto.user.UserRegisterResponseDto;
import com.main.webapplication.exception.RestException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface UserApi {

    @RequestMapping(path = "/register", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    UserRegisterResponseDto register(UserRegisterRequestDto userRegisterRequestDto) throws RestException;

    @RequestMapping(path = "/login", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    UserLogInResponsetDto login(UserLogInRequestDto userLogInRequestDto) throws RestException;

}
