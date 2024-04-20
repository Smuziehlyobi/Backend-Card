package com.hackathon.prduction.services;

import com.hackathon.prduction.domain.dto.category.CategoryRequestDTO;
import com.hackathon.prduction.domain.entity.Category;
import com.hackathon.prduction.exceptions.category.CategoryNotFoundByIdException;

import java.util.List;


public interface CategoryService {
    CategoryRequestDTO createCategory(Category category);
    void deleteCategory(Long categoryId) throws CategoryNotFoundByIdException;

    List<CategoryRequestDTO> getAllCategories();

    CategoryRequestDTO getOneCategory(Long categoryId) throws CategoryNotFoundByIdException;


}
