package com.webapplication.mapper;

import com.webapplication.dao.UserRepository;
import com.webapplication.dto.residence.AddResidenceRequestDto;
import com.webapplication.entity.ResidenceEntity;
import com.webapplication.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class ResidenceMapper {

    @Autowired
    private UserRepository userRepository;

    public ResidenceEntity toResidenceEntity(AddResidenceRequestDto addResidenceRequestDto) {
        if (addResidenceRequestDto == null) {
            return null;
        }

        ResidenceEntity residenceEntity = new ResidenceEntity();
        residenceEntity.setAddress(addResidenceRequestDto.getAddress());
        residenceEntity.setGeoX(addResidenceRequestDto.getGeoX());
        residenceEntity.setGeoY(addResidenceRequestDto.getGeoY());
        residenceEntity.setDatesAvailable(addResidenceRequestDto.getDatesAvailable());
        residenceEntity.setCapacity(addResidenceRequestDto.getCapacity());
        residenceEntity.setPrize(addResidenceRequestDto.getPrize());
        residenceEntity.setType(addResidenceRequestDto.getType());
        residenceEntity.setRules(addResidenceRequestDto.getRules());
        residenceEntity.setDescription(addResidenceRequestDto.getDescription());
        residenceEntity.setBathrooms(addResidenceRequestDto.getBathrooms());
        residenceEntity.setSize(addResidenceRequestDto.getSize());
        residenceEntity.setBedrooms(addResidenceRequestDto.getBedrooms());
        residenceEntity.setLivingRoom(addResidenceRequestDto.getLivingRoom());
        residenceEntity.setLocation(addResidenceRequestDto.getLocation());
        UserEntity user = userRepository.findUserEntityByUserId(addResidenceRequestDto.getUserId());
        user.getResidences().add(residenceEntity);
        residenceEntity.setUsers(Collections.singletonList(user));
        return residenceEntity;
    }

}
