package com.hackathon.prduction.domain.mapper;

import com.hackathon.prduction.domain.dto.security.CreateUserRequestDTO;
import com.hackathon.prduction.domain.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CreateUserRequestDTOMapper extends EntityMapper<CreateUserRequestDTO, User>{
    @Override
    User toEntity(CreateUserRequestDTO createUserRequestDTO);

    @Override
    default CreateUserRequestDTO toDto(User entity) {
        return null;
    }

    @Override
    default List<User> toEntity(List<CreateUserRequestDTO> dtoList) {
        return null;
    }

    @Override
    default List<CreateUserRequestDTO> toDto(List<User> entityList) {
        return null;
    }

    @Override
    default void partialUpdate(User entity, CreateUserRequestDTO dto) {

    }
}
