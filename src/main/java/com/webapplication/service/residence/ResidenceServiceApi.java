package com.webapplication.service.residence;


import com.webapplication.dto.residence.*;
import com.webapplication.dto.user.UserUtilsDto;
import com.webapplication.entity.ResidenceEntity;
import com.webapplication.exception.RestException;

import java.util.List;

public interface ResidenceServiceApi {

    AddResidenceResponseDto addResidence(AddResidenceRequestDto addResidenceRequestDto) throws RestException;

    List<ResidenceEntity> searchResidence(SearchResidenceDto searchResidenceDto) throws RestException;

    ResidenceEntity searchResidenceById(SearchResidenceByIdDto searchResidenceByIdDto) throws RestException;

    public List<ResidenceEntity> getAllResidences();

    public ResidenceEntity addComment(AddCommentToResidenceDto addCommentToResidenceDto);

    public ResidenceEntity updateResidence(ResidenceEntity residenceEntity) throws RestException;

    void deleteResidence(ResidenceEntity residenceEntity);

    List<ResidenceEntity> getResidencesBasedOnUserSearchedLocations(UserUtilsDto userUtilsDto);
}
