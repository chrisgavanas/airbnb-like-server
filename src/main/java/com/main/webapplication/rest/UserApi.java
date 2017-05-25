package com.main.webapplication.rest;

import com.main.webapplication.dto.UserRegisterRequestDto;
import com.main.webapplication.dto.UserRegisterResponseDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface UserApi {

    @RequestMapping(path = "/register", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    UserRegisterResponseDto register(UserRegisterRequestDto userRegisterRequestDto) throws Exception;

}
