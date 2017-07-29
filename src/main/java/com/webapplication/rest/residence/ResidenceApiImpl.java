package com.webapplication.rest.residence;


import com.webapplication.dto.residence.*;
import com.webapplication.entity.CommentEntity;
import com.webapplication.entity.ResidenceEntity;
import com.webapplication.exception.RestException;
import com.webapplication.service.residence.ResidenceServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

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

    @Override
    public ResidenceEntity searchResidenceById(SearchResidenceByIdDto searchResidenceByIdDto) throws RestException {
        return residenceServiceApi.searchResidenceById(searchResidenceByIdDto);
    }

    @Override
    public Iterable<ResidenceEntity> getAllResidence() throws RestException {
        return residenceServiceApi.getAllResidences();
    }

    @Override
    public void addComment(AddCommentToResidenceDto addCommentToResidenceDto) throws RestException {
        residenceServiceApi.addComment(addCommentToResidenceDto);
    }

}
