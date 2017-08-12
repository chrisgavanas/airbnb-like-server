package com.webapplication.rest.user;

import com.webapplication.dto.user.*;
import com.webapplication.exception.RestException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface UserApi {

    @RequestMapping(path = "/register", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    UserRegisterResponseDto register(UserRegisterRequestDto userRegisterRequestDto) throws RestException;

    @RequestMapping(path = "/login", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    UserLogInResponseDto login(UserLogInRequestDto userLogInRequestDto) throws RestException;

    @RequestMapping(path = "/getProfile", method = RequestMethod.POST,consumes = "application/json",produces = "application/json")
    UserProfileDto getProfile(UserUtilsDto userUtilsDto) throws RestException;

    @RequestMapping(path = "/updateProfile", method = RequestMethod.POST,consumes = "application/json",produces = "application/json")
    UserProfileDto updateProfile(UserUpdateProfileDto userUpdateProfileDto) throws RestException;
    
}
