package com.webapplication.dao;

import com.webapplication.entity.ResidenceEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ResidenceRepository extends CrudRepository<ResidenceEntity, Integer> {

    List<ResidenceEntity> findByLocationOrCapacityOrDatesAvailable(String location, Integer capacity, String datesAvailable);

}
