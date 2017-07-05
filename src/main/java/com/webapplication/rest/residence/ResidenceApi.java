package com.webapplication.rest.residence;


import com.webapplication.dto.residence.AddResidenceRequestDto;
import com.webapplication.dto.residence.AddResidenceResponseDto;
import com.webapplication.exception.RestException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface ResidenceApi {

    @RequestMapping(path = "/residence", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    AddResidenceResponseDto addResidence(AddResidenceRequestDto addResidenceRequestDto) throws RestException;

}
