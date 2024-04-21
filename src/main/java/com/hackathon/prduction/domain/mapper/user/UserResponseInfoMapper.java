package com.hackathon.prduction.domain.mapper.user;

import com.hackathon.prduction.domain.dto.user.UserResponseInfoDTO;
import com.hackathon.prduction.domain.entity.User;
import com.hackathon.prduction.domain.mapper.EntityResponseMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserResponseInfoMapper extends EntityResponseMapper<UserResponseInfoDTO, User> {
    @Override
    User toEntity(UserResponseInfoDTO dto);

    @Override
    UserResponseInfoDTO toDto(User entity);

    @Override
    List<User> toEntity(List<UserResponseInfoDTO> dtoList);

    @Override
    List<UserResponseInfoDTO> toDto(List<User> entityList);
}
