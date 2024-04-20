package com.hackathon.prduction.services;

import com.hackathon.prduction.domain.dto.CategoryDTO;
import com.hackathon.prduction.domain.dto.TransactionDTO;
import com.hackathon.prduction.domain.entity.Category;
import com.hackathon.prduction.domain.entity.Transaction;
import com.hackathon.prduction.exceptions.category.CategoryNotFoundByIdException;

import java.util.List;


public interface CategoryService {
    CategoryDTO createCategory(Category category);
    void deleteCategory(Long categoryId) throws CategoryNotFoundByIdException;

    List<CategoryDTO> getAllCategories();

    CategoryDTO getOneCategory(Long categoryId) throws CategoryNotFoundByIdException;


}
