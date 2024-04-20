package com.hackathon.prduction.domain.mapper;

import com.hackathon.prduction.domain.dto.AgeCategoryDTO;
import com.hackathon.prduction.domain.entity.AgeCategory;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")

public interface AgeCategoryMapper extends EntityMapper<AgeCategoryDTO, AgeCategory> {
    @Override
    AgeCategory toEntity(AgeCategoryDTO dto);

    @Override
    AgeCategoryDTO toDto(AgeCategory entity);

    @Override
    List<AgeCategory> toEntity(List<AgeCategoryDTO> dtoList);

    @Override
    List<AgeCategoryDTO> toDto(List<AgeCategory> entityList);

    @Override
    void partialUpdate(AgeCategory entity, AgeCategoryDTO dto);
}
