package com.webapplication.mapper;

import com.webapplication.dao.RoleRepository;
import com.webapplication.dto.user.*;
import com.webapplication.entity.CommentEntity;
import com.webapplication.entity.ResidenceEntity;
import com.webapplication.entity.RoleEntity;
import com.webapplication.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    @Autowired
    private RoleRepository roleRepository;

    public UserEntity toUserEntity(UserRegisterRequestDto userRegisterRequestDto, String encodedSalt, String encodedPassword) {
        if (userRegisterRequestDto == null) {
            return null;
        }

        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userRegisterRequestDto.getUsername());
        userEntity.setPassword(encodedPassword);
        userEntity.setName(userRegisterRequestDto.getName());
        userEntity.setSurname(userRegisterRequestDto.getSurname());
        userEntity.setEmail(userRegisterRequestDto.getEmail());
        userEntity.setPhoneNumber(userRegisterRequestDto.getPhoneNumber());
        userEntity.setSalt(encodedSalt);
        userEntity.getMailbox().setUser(userEntity);
        List<RoleEntity> roles = new LinkedList<>();
        userRegisterRequestDto.getRoleDtos()
                .stream()
                .map(RoleDto::getDescription)
                .forEach(role -> roles.add(roleRepository.findRoleEntityByDescription(role)));
        userEntity.setRoles(roles);

        return userEntity;
    }

    public UserRegisterResponseDto toUserRegisterResponseDto(UserEntity userEntity) {
        if (userEntity == null) {
            return null;
        }

        UserRegisterResponseDto userRegisterResponseDto = new UserRegisterResponseDto();
        userRegisterResponseDto.setUsername(userEntity.getUsername());
        userRegisterResponseDto.setPassword(userEntity.getPassword());
        userRegisterResponseDto.setName(userEntity.getName());
        userRegisterResponseDto.setSurname(userEntity.getSurname());
        userRegisterResponseDto.setEmail(userEntity.getEmail());
        userRegisterResponseDto.setPhoneNumber(userEntity.getPhoneNumber());
        userRegisterResponseDto.setRoleDtos(roleEntitiesToRoleDtos(userEntity.getRoles()));
        return userRegisterResponseDto;
    }

    public UserLogInResponseDto toUserLogInResponseDto(UserEntity userEntity, UUID authToken) {
        UserLogInResponseDto userLogInResponseDto = new UserLogInResponseDto();
        userLogInResponseDto.setUsername(userEntity.getUsername());
        userLogInResponseDto.setRoleDtos(roleEntitiesToRoleDtos(userEntity.getRoles()));
        userLogInResponseDto.setAuthToken(authToken);

        return userLogInResponseDto;
    }


    private List<RoleDto> roleEntitiesToRoleDtos(List<RoleEntity> roles) {
        return roles.stream()
                .map(roleEntity -> RoleDto.valueOf(roleEntity.getDescription()))
                .collect(Collectors.toList());
    }

    public UserProfileDto toUserProfileDto(UserEntity user) {
        UserProfileDto userProfileDto = new UserProfileDto();
        userProfileDto.setEmail(user.getEmail());
        userProfileDto.setName(user.getName());
        userProfileDto.setSurname(user.getSurname());
        userProfileDto.setPhoneNumber(user.getPhoneNumber());

        List<CommentEntity> comments = new ArrayList<>();
        for(ResidenceEntity r : user.getResidences())
            comments.addAll(r.getComments());

        userProfileDto.setComments(comments);

        return userProfileDto;
    }
}
