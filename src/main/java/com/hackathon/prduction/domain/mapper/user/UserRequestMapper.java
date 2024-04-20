package com.hackathon.prduction.domain.mapper.user;

import com.hackathon.prduction.domain.dto.user.UserResponseDTO;
import com.hackathon.prduction.domain.entity.User;
import com.hackathon.prduction.domain.mapper.EntityRequestMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserRequestMapper extends EntityRequestMapper<UserResponseDTO, User> {
    @Override
    User toEntity(UserResponseDTO dto);

    @Override
    UserResponseDTO toDto(User entity);

    @Override
    List<User> toEntity(List<UserResponseDTO> dtoList);

    @Override
    List<UserResponseDTO> toDto(List<User> entityList);

}
