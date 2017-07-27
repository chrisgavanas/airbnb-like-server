package com.webapplication.service.residence;


import com.webapplication.dto.residence.AddResidenceRequestDto;
import com.webapplication.dto.residence.AddResidenceResponseDto;
import com.webapplication.dto.residence.SearchResidenceDto;
import com.webapplication.entity.ResidenceEntity;
import com.webapplication.exception.RestException;

import java.util.List;

public interface ResidenceServiceApi {

    AddResidenceResponseDto addResidence(AddResidenceRequestDto addResidenceRequestDto) throws RestException;

    List<ResidenceEntity> searchResidence(SearchResidenceDto searchResidenceDto) throws RestException;
}
