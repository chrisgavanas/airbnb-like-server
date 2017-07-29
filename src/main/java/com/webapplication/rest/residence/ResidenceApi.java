package com.webapplication.rest.residence;


import com.webapplication.dto.residence.*;
import com.webapplication.entity.CommentEntity;
import com.webapplication.entity.ResidenceEntity;
import com.webapplication.exception.RestException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface ResidenceApi {

    @RequestMapping(path = "/residence", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    AddResidenceResponseDto addResidence(AddResidenceRequestDto addResidenceRequestDto) throws RestException;

    @RequestMapping(path = "/search_residence" , method = RequestMethod.POST ,consumes = "application/json", produces = "application/json")
    List<ResidenceEntity> searchResidence(SearchResidenceDto searchResidenceDto) throws  RestException;

    @RequestMapping(path = "/search_residence_by_id" , method = RequestMethod.POST ,consumes = "application/json", produces = "application/json")
    ResidenceEntity searchResidenceById(SearchResidenceByIdDto searchResidenceByIdDto) throws  RestException;

    @RequestMapping(path = "/get_all_residences" , method = RequestMethod.GET ,produces = "application/json")
    Iterable<ResidenceEntity> getAllResidence() throws  RestException;

    @RequestMapping(path = "/addComment" , method = RequestMethod.POST ,consumes = "application/json",produces = "application/json")
    void addComment(AddCommentToResidenceDto addCommentToResidenceDto) throws RestException;

}
