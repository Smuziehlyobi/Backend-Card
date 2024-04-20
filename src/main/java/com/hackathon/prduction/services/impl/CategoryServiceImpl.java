package com.hackathon.prduction.services.impl;

import com.hackathon.prduction.domain.dto.CategoryDTO;
import com.hackathon.prduction.domain.mapper.CategoryMapper;
import com.hackathon.prduction.domain.entity.Category;
import com.hackathon.prduction.exceptions.category.CategoryNotFoundByIdException;
import com.hackathon.prduction.exceptions.transaction.TransactionNotFoundByIdException;
import com.hackathon.prduction.repository.CategoryRepository;
import com.hackathon.prduction.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryService categoryService;
    private final CategoryRepository categoryRepo;
    private final CategoryMapper categoryMapper;

    @Autowired
    public CategoryServiceImpl(CategoryService categoryService,
                               CategoryRepository categoryRepo,
                               CategoryMapper categoryMapper) {
        this.categoryService = categoryService;
        this.categoryRepo = categoryRepo;
        this.categoryMapper = categoryMapper;
    }


    @Override
    public CategoryDTO createCategory(Category category) {
        CategoryDTO categoryDTO = categoryMapper.toDto(category);
        categoryRepo.save(category);
        return categoryDTO;
    }

    @Override
    public void deleteCategory(Long categoryId) throws CategoryNotFoundByIdException {
        Category category = categoryRepo.findById(categoryId).orElse(null);
        if(category == null){
            throw new CategoryNotFoundByIdException("Category with such ID does not exist.");
        }
        categoryRepo.delete(category);
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        List<Category> categories = categoryRepo.findAll();
        List<CategoryDTO> categoryDTOS = categoryMapper.toDto(categories);
        return categoryDTOS;
    }

    @Override
    public CategoryDTO getOneCategory(Long categoryId) throws CategoryNotFoundByIdException {
        Category category = categoryRepo.findById(categoryId).orElse(null);
        if(category == null) {
            throw new CategoryNotFoundByIdException("Category with such ID does not exist.");
        }
        CategoryDTO categoryDTO = categoryMapper.toDto(category);
        return categoryDTO;
    }

}