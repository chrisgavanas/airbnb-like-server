package com.webapplication.service.residence;


import com.webapplication.dto.residence.AddResidenceRequestDto;
import com.webapplication.dto.residence.AddResidenceResponseDto;
import com.webapplication.exception.RestException;

public interface ResidenceServiceApi {

    AddResidenceResponseDto addResidence(AddResidenceRequestDto addResidenceRequestDto) throws RestException;

}
