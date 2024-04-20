package com.hackathon.prduction.domain.mapper.category;

import com.hackathon.prduction.domain.dto.category.CategoryRequestDTO;
import com.hackathon.prduction.domain.entity.Category;
import com.hackathon.prduction.domain.mapper.EntityRequestMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryRequestMapper extends EntityRequestMapper<CategoryRequestDTO, Category> {
    @Override
    Category toEntity(CategoryRequestDTO dto);

    @Override
    CategoryRequestDTO toDto(Category entity);

    @Override
    List<Category> toEntity(List<CategoryRequestDTO> dtoList);

    @Override
    List<CategoryRequestDTO> toDto(List<Category> entityList);

}
