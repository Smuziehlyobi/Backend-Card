package com.hackathon.prduction.domain.mapper.role;

import com.hackathon.prduction.domain.dto.role.RoleRequestDTO;
import com.hackathon.prduction.domain.entity.Role;
import com.hackathon.prduction.domain.mapper.EntityRequestMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper extends EntityRequestMapper<RoleRequestDTO, Role> {
    @Override
    Role toEntity(RoleRequestDTO dto);

    @Override
    RoleRequestDTO toDto(Role entity);

    @Override
    List<Role> toEntity(List<RoleRequestDTO> dtoList);

    @Override
    List<RoleRequestDTO> toDto(List<Role> entityList);

}
