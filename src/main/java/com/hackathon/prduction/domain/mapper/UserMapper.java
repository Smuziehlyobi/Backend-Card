package com.hackathon.prduction.domain.mapper;

import com.hackathon.prduction.domain.dto.UserDTO;
import com.hackathon.prduction.domain.dto.security.CreateUserRequestDTO;
import com.hackathon.prduction.domain.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper extends EntityMapper<UserDTO, User> {
    @Override
    User toEntity(UserDTO dto);

    @Override
    User toEntity(CreateUserRequestDTO createUserRequestDTO);

    @Override
    UserDTO toDto(User entity);

    @Override
    List<User> toEntity(List<UserDTO> dtoList);

    @Override
    List<UserDTO> toDto(List<User> entityList);

    @Override
    void partialUpdate(User entity, UserDTO dto);
}
