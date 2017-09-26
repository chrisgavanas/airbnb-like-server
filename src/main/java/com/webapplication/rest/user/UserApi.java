package com.webapplication.rest.user;

import com.webapplication.dto.user.*;
<<<<<<< HEAD
import com.webapplication.entity.ResidenceEntity;
=======
import com.webapplication.entity.UserEntity;
>>>>>>> 399052ab6f5c54ce43f4ea0e085a17dc737fff6c
import com.webapplication.exception.RestException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface UserApi {

    @RequestMapping(path = "/register", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    UserEntity register(UserRegisterRequestDto userRegisterRequestDto) throws RestException;

    @RequestMapping(path = "/login", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    UserEntity login(UserLogInRequestDto userLogInRequestDto) throws RestException;

    @RequestMapping(path = "/getProfile", method = RequestMethod.POST,consumes = "application/json",produces = "application/json")
<<<<<<< HEAD
    UserProfileDto getProfile(UserUtilsDto userUtilsDto) throws RestException;

    @RequestMapping(path = "/getUserResidences" , method = RequestMethod.GET ,produces = "application/json")
    List<ResidenceEntity> getUserResidences(UserUtilsDto userUtilsDto) throws  RestException;
=======
    UserEntity getProfile(UserUtilsDto userUtilsDto) throws RestException;

    @RequestMapping(path = "/updateProfile", method = RequestMethod.POST,consumes = "application/json",produces = "application/json")
    UserEntity updateProfile(UserUpdateProfileDto userUpdateProfileDto) throws RestException;
    
>>>>>>> 399052ab6f5c54ce43f4ea0e085a17dc737fff6c
}
