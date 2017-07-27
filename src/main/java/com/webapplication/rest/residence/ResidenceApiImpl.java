package com.webapplication.rest.residence;


import com.webapplication.dto.residence.AddResidenceRequestDto;
import com.webapplication.dto.residence.AddResidenceResponseDto;
import com.webapplication.dto.residence.SearchResidenceDto;
import com.webapplication.entity.ResidenceEntity;
import com.webapplication.exception.RestException;
import com.webapplication.service.residence.ResidenceServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Component
public class ResidenceApiImpl implements ResidenceApi {

    @Autowired
    private ResidenceServiceApi residenceServiceApi;

    @Override
    public AddResidenceResponseDto addResidence(@RequestBody AddResidenceRequestDto addResidenceRequestDto) throws RestException {
        return residenceServiceApi.addResidence(addResidenceRequestDto);
    }

    @Override
    public List<ResidenceEntity> searchResidence(@RequestBody SearchResidenceDto searchResidenceDto) throws  RestException {
        return residenceServiceApi.searchResidence(searchResidenceDto);
    }

}
