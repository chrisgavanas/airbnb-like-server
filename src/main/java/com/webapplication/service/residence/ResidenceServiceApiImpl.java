package com.webapplication.service.residence;

import com.webapplication.dao.ResidenceRepository;
import com.webapplication.dao.UserRepository;
import com.webapplication.dto.residence.*;
import com.webapplication.dto.user.UserUtilsDto;
import com.webapplication.entity.CommentEntity;
import com.webapplication.entity.ResidenceEntity;
import com.webapplication.entity.SearchEntity;
import com.webapplication.entity.UserEntity;
import com.webapplication.exception.RestException;
import com.webapplication.mapper.ResidenceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Transactional
@Service
public class ResidenceServiceApiImpl implements ResidenceServiceApi {

    @Autowired
    private ResidenceMapper residenceMapper;
    @Autowired
    private ResidenceRepository residenceRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public AddResidenceResponseDto addResidence(AddResidenceRequestDto addResidenceRequestDto) throws RestException {
        ResidenceEntity residenceEntity = residenceMapper.toResidenceEntity(addResidenceRequestDto);
        residenceEntity = residenceRepository.save(residenceEntity);
        return residenceMapper.toAddResidenceResponseDto(residenceEntity);
    }

    @Override
    public List<ResidenceEntity> searchResidence(SearchResidenceDto searchResidenceDto) throws RestException {
        String location = searchResidenceDto.getLocation();
        Integer capacity = searchResidenceDto.getCapacity();
        String datesAvailable = searchResidenceDto.getDatesAvailable();
        String username = searchResidenceDto.getUsername();

        UserEntity user = userRepository.findUserEntityByUsername(username);
        SearchEntity searchEntity = new SearchEntity();
        searchEntity.setLocation(location);
        searchEntity.getUsers().add(user);

        user.getSearchedLocations().add(searchEntity);

        return residenceRepository.findByLocationOrCapacityOrDatesAvailable(location,capacity,datesAvailable);
    }

    @Override
    public ResidenceEntity searchResidenceById(SearchResidenceByIdDto searchResidenceByIdDto) throws RestException {
        Integer residenceId = searchResidenceByIdDto.getResidenceId();
        return residenceRepository.findOne(residenceId);
    }

    @Override
    public List<ResidenceEntity> getAllResidences() {
        List<ResidenceEntity> resultSet = new ArrayList<>();
        residenceRepository.findAll().forEach(resultSet::add);
        return resultSet;
    }

    @Override
    public ResidenceEntity addComment(AddCommentToResidenceDto addCommentToResidenceDto) {
        Integer residenceId = addCommentToResidenceDto.getResidenceId();
        String comment = addCommentToResidenceDto.getComment();
        Integer grade = addCommentToResidenceDto.getGrade();
        ResidenceEntity residenceEntity = residenceRepository.findOne(residenceId);

        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setComment(comment);
        commentEntity.setGrade(grade);
        commentEntity.setResidenceEntity(residenceEntity);

        residenceEntity.getComments().add(commentEntity);
        return residenceEntity;
    }

    @Override
    public ResidenceEntity updateResidence(ResidenceEntity residenceEntity) throws RestException {
        if ( residenceRepository.findOne(residenceEntity.getResidenceId()) == null  )
            return null;
        return residenceRepository.save(residenceEntity);
    }

    @Override
    public void deleteResidence(ResidenceEntity residenceEntity) {
        ResidenceEntity res = residenceRepository.findOne(residenceEntity.getResidenceId());

        if(res == null)
            return ;

        List<UserEntity> users = res.getUsers();
        if(users.size() > 0){
            for(UserEntity u:users)
                u.getResidences().remove(res);
        }

        residenceRepository.delete(res);
    }

    @Override
    public List<ResidenceEntity> getResidencesBasedOnUserSearchedLocations(UserUtilsDto userUtilsDto) {
        UserEntity user = userRepository.findUserEntityByUsername(userUtilsDto.getUsername());
        Set<ResidenceEntity> resultSet = new HashSet<>();
        List<SearchEntity> searchedResidences = user.getSearchedLocations();

        for(SearchEntity se : searchedResidences){
            List<ResidenceEntity> re = residenceRepository.findByLocationOrCapacityOrDatesAvailable(se.getLocation(),null,null);
            for(ResidenceEntity r : re){
                if (! resultSet.contains(r))
                    resultSet.add(r);
            }
        }

        return new ArrayList<>(resultSet);
    }

}
