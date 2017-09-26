package com.webapplication.rest.user;

import com.webapplication.dto.user.*;
import com.webapplication.entity.ResidenceEntity;
import com.webapplication.exception.RestException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface UserApi {

    @RequestMapping(path = "/register", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    UserRegisterResponseDto register(UserRegisterRequestDto userRegisterRequestDto) throws RestException;

    @RequestMapping(path = "/login", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    UserLogInResponseDto login(UserLogInRequestDto userLogInRequestDto) throws RestException;

    @RequestMapping(path = "/getProfile", method = RequestMethod.POST,consumes = "application/json",produces = "application/json")
    UserProfileDto getProfile(UserUtilsDto userUtilsDto) throws RestException;

    @RequestMapping(path = "/getUserResidences" , method = RequestMethod.GET ,produces = "application/json")
    List<ResidenceEntity> getUserResidences(UserUtilsDto userUtilsDto) throws  RestException;
}
