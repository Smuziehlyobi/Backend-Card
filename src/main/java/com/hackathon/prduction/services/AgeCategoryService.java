package com.hackathon.prduction.services;

import com.hackathon.prduction.domain.dto.agecategory.AgeCategoryRequestDTO;
import com.hackathon.prduction.domain.entity.AgeCategory;
import com.hackathon.prduction.exceptions.agecategory.AgeCategoryNotFoundByIdException;

import java.util.List;

public interface AgeCategoryService {
    AgeCategoryRequestDTO createAgeCategory(AgeCategory ageCategory);
    void deleteAgeCategory(Long ageCategoryId) throws AgeCategoryNotFoundByIdException;
    List<AgeCategoryRequestDTO> getAllAgeCategories();
    AgeCategoryRequestDTO getOneAgeCategory(Long ageCategoryId) throws AgeCategoryNotFoundByIdException;
}
