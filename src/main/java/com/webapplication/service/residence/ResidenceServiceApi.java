package com.webapplication.service.residence;


import com.webapplication.dto.residence.*;
import com.webapplication.entity.CommentEntity;
import com.webapplication.entity.ResidenceEntity;
import com.webapplication.exception.RestException;

import java.util.List;

public interface ResidenceServiceApi {

    AddResidenceResponseDto addResidence(AddResidenceRequestDto addResidenceRequestDto) throws RestException;

    List<ResidenceEntity> searchResidence(SearchResidenceDto searchResidenceDto) throws RestException;

    ResidenceEntity searchResidenceById(SearchResidenceByIdDto searchResidenceByIdDto) throws RestException;

    public Iterable<ResidenceEntity> getAllResidences();

    void addComment(AddCommentToResidenceDto addCommentToResidenceDto);
}
