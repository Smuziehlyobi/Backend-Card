package com.hackathon.prduction.domain.mapper;

import com.hackathon.prduction.domain.dto.RoleDTO;
import com.hackathon.prduction.domain.entity.Role;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper extends EntityMapper<RoleDTO, Role> {
    @Override
    Role toEntity(RoleDTO dto);

    @Override
    RoleDTO toDto(Role entity);

    @Override
    List<Role> toEntity(List<RoleDTO> dtoList);

    @Override
    List<RoleDTO> toDto(List<Role> entityList);

    @Override
    void partialUpdate(Role entity, RoleDTO dto);
}
