package com.hackathon.prduction.services.impl;

import com.hackathon.prduction.domain.dto.category.CategoryRequestDTO;
import com.hackathon.prduction.domain.mapper.category.CategoryRequestMapper;
import com.hackathon.prduction.domain.entity.Category;
import com.hackathon.prduction.exceptions.category.CategoryNotFoundByIdException;
import com.hackathon.prduction.repository.CategoryRepository;
import com.hackathon.prduction.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepo;

    private final CategoryRequestMapper categoryRequestMapper;

    @Override
    public CategoryRequestDTO createCategory(Category category) {
        CategoryRequestDTO categoryRequestDTO = categoryRequestMapper.toDto(category);
        categoryRepo.save(category);
        return categoryRequestDTO;
    }

    @Override
    public void deleteCategory(Long categoryId) throws CategoryNotFoundByIdException {
        Category category = categoryRepo.findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundByIdException("Category with such ID does not exist."));
        categoryRepo.delete(category);
    }

    @Override
    public List<CategoryRequestDTO> getAllCategories() {
        List<Category> categories = categoryRepo.findAll();
        List<CategoryRequestDTO> categoryRequestDTOS = categoryRequestMapper.toDto(categories);
        return categoryRequestDTOS;
    }

    @Override
    public CategoryRequestDTO getOneCategory(Long categoryId) throws CategoryNotFoundByIdException {
        Category category = categoryRepo.findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundByIdException("Category with such ID does not exist."));
        return categoryRequestMapper.toDto(category);
    }

}
