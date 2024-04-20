package com.hackathon.prduction.services.impl;

import com.hackathon.prduction.domain.dto.AgeCategoryDTO;
import com.hackathon.prduction.domain.entity.AgeCategory;
import com.hackathon.prduction.domain.mapper.AgeCategoryMapper;
import com.hackathon.prduction.exceptions.agecategory.AgeCategoryNotFoundByIdException;
import com.hackathon.prduction.repository.AgeCategoryRepository;
import com.hackathon.prduction.services.AgeCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgeCategoryServiceImpl implements AgeCategoryService {
    private final AgeCategoryRepository ageCategoryRepository;
    private final AgeCategoryService ageCategoryService;
    private final AgeCategoryMapper ageCategoryMapper;

    @Autowired
    public AgeCategoryServiceImpl(AgeCategoryRepository ageCategoryRepository, AgeCategoryService ageCategoryService, AgeCategoryMapper ageCategoryMapper) {
        this.ageCategoryRepository = ageCategoryRepository;
        this.ageCategoryService = ageCategoryService;
        this.ageCategoryMapper = ageCategoryMapper;
    }
    @Override
    public AgeCategoryDTO createAgeCategory(AgeCategory ageCategory) {
        AgeCategoryDTO ageCategoryDTO = ageCategoryMapper.toDto(ageCategory);
        ageCategoryRepository.save(ageCategory);
        return ageCategoryDTO;
    }

    @Override
    public void deleteAgeCategory(Long ageCategoryId) throws AgeCategoryNotFoundByIdException {
        AgeCategory ageCategory = ageCategoryRepository.findById(ageCategoryId).orElse(null);
        if (ageCategory == null) {
            throw new AgeCategoryNotFoundByIdException("Age category with such ID does not exist.");
        }
        ageCategoryRepository.delete(ageCategory);
    }

    @Override
    public List<AgeCategoryDTO> getAllAgeCategories() {
        List<AgeCategory> ageCategories = ageCategoryRepository.findAll();
        List<AgeCategoryDTO> ageCategoryDTOs = ageCategoryMapper.toDto(ageCategories);
        return ageCategoryDTOs;
    }

    @Override
    public AgeCategoryDTO getOneAgeCategory(Long ageCategoryId) throws AgeCategoryNotFoundByIdException {
        AgeCategory ageCategory = ageCategoryRepository.findById(ageCategoryId).orElse(null);
        if (ageCategory == null) {
            throw new AgeCategoryNotFoundByIdException("Age category with such ID does not exist.");
        }
        AgeCategoryDTO ageCategoryDTO = ageCategoryMapper.toDto(ageCategory);
        return ageCategoryDTO;
    }

}
