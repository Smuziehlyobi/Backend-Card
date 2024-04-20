package com.hackathon.prduction.services;

import com.hackathon.prduction.domain.dto.AgeCategoryDTO;
import com.hackathon.prduction.domain.dto.CardDTO;
import com.hackathon.prduction.domain.entity.AgeCategory;
import com.hackathon.prduction.exceptions.agecategory.AgeCategoryNotFoundByIdException;

import java.util.List;

public interface AgeCategoryService {
    AgeCategoryDTO createAgeCategory(AgeCategory ageCategory);
    void deleteAgeCategory(Long ageCategoryId) throws AgeCategoryNotFoundByIdException;
    List<AgeCategoryDTO> getAllAgeCategories();
    AgeCategoryDTO getOneAgeCategory(Long ageCategoryId) throws AgeCategoryNotFoundByIdException;
}
