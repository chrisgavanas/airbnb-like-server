package com.main.webapplication.dao;

import com.main.webapplication.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {

    UserEntity findUserEntityByUsername(String username);

}
