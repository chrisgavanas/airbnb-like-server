package com.webapplication.service.residence;

import com.webapplication.dao.ResidenceRepository;
import com.webapplication.dto.residence.AddResidenceRequestDto;
import com.webapplication.dto.residence.AddResidenceResponseDto;
import com.webapplication.dto.residence.SearchResidenceDto;
import com.webapplication.entity.ResidenceEntity;
import com.webapplication.exception.RestException;
import com.webapplication.mapper.ResidenceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ResidenceServiceApiImpl implements ResidenceServiceApi {

    @Autowired
    private ResidenceMapper residenceMapper;

    @Autowired
    private ResidenceRepository residenceRepository;

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
        return residenceRepository.findByLocationOrCapacityOrDatesAvailable(location,capacity,datesAvailable);
    }

}
