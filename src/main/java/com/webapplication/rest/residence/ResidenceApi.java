package com.webapplication.rest.residence;


import com.webapplication.dto.residence.AddResidenceRequestDto;
import com.webapplication.dto.residence.AddResidenceResponseDto;
import com.webapplication.dto.residence.SearchResidenceDto;
import com.webapplication.entity.ResidenceEntity;
import com.webapplication.exception.RestException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface ResidenceApi {

    @RequestMapping(path = "/residence", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    AddResidenceResponseDto addResidence(AddResidenceRequestDto addResidenceRequestDto) throws RestException;

    @RequestMapping(path = "/search_residence" , method = RequestMethod.POST ,consumes = "application/json", produces = "application/json")
    List<ResidenceEntity> searchResidence(SearchResidenceDto searchResidenceDto) throws  RestException;

}
