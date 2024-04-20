package com.hackathon.prduction.domain.mapper.user;

import com.hackathon.prduction.domain.dto.security.CreateUserRequestDTO;
import com.hackathon.prduction.domain.entity.User;
import com.hackathon.prduction.domain.mapper.EntityRequestMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CreateUserRequestDTOMapper extends EntityRequestMapper<CreateUserRequestDTO, User> {
    @Override
    User toEntity(CreateUserRequestDTO createUserRequestDTO);

    @Override
    CreateUserRequestDTO toDto(User entity);

    @Override
    List<User> toEntity(List<CreateUserRequestDTO> dtoList);

    @Override
    List<CreateUserRequestDTO> toDto(List<User> entityList);

}
