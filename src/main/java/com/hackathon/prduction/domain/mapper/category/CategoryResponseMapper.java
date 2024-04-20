package com.hackathon.prduction.domain.mapper.category;

import com.hackathon.prduction.domain.dto.category.CategoryResponseDTO;
import com.hackathon.prduction.domain.entity.Category;
import com.hackathon.prduction.domain.mapper.EntityResponseMapper;

import java.util.List;

public interface CategoryResponseMapper extends EntityResponseMapper<CategoryResponseDTO, Category> {
    @Override
    Category toEntity(CategoryResponseDTO dto);

    @Override
    CategoryResponseDTO toDto(Category entity);

    @Override
    List<Category> toEntity(List<CategoryResponseDTO> dtoList);

    @Override
    List<CategoryResponseDTO> toDto(List<Category> entityList);
}
