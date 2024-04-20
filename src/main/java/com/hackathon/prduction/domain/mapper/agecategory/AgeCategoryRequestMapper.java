package com.hackathon.prduction.domain.mapper.agecategory;

import com.hackathon.prduction.domain.dto.agecategory.AgeCategoryRequestDTO;
import com.hackathon.prduction.domain.entity.AgeCategory;
import com.hackathon.prduction.domain.mapper.EntityRequestMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AgeCategoryRequestMapper extends EntityRequestMapper<AgeCategoryRequestDTO, AgeCategory> {
    @Override
    AgeCategory toEntity(AgeCategoryRequestDTO dto);

    @Override
    AgeCategoryRequestDTO toDto(AgeCategory entity);

    @Override
    List<AgeCategory> toEntity(List<AgeCategoryRequestDTO> dtoList);

    @Override
    List<AgeCategoryRequestDTO> toDto(List<AgeCategory> entityList);

}
