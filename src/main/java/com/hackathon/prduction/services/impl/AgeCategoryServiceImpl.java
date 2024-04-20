package com.hackathon.prduction.services.impl;

import com.hackathon.prduction.domain.dto.agecategory.AgeCategoryRequestDTO;
import com.hackathon.prduction.domain.entity.AgeCategory;
import com.hackathon.prduction.domain.mapper.agecategory.AgeCategoryRequestMapper;
import com.hackathon.prduction.exceptions.agecategory.AgeCategoryNotFoundByIdException;
import com.hackathon.prduction.repository.AgeCategoryRepository;
import com.hackathon.prduction.services.AgeCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgeCategoryServiceImpl implements AgeCategoryService {
    private final AgeCategoryRepository ageCategoryRepository;

    private final AgeCategoryRequestMapper ageCategoryMapper;


    @Override
    public AgeCategoryRequestDTO createAgeCategory(AgeCategory ageCategory) {
        AgeCategoryRequestDTO ageCategoryRequestDTO = ageCategoryMapper.toDto(ageCategory);
        ageCategoryRepository.save(ageCategory);
        return ageCategoryRequestDTO;
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
    public List<AgeCategoryRequestDTO> getAllAgeCategories() {
        List<AgeCategory> ageCategories = ageCategoryRepository.findAll();
        List<AgeCategoryRequestDTO> ageCategoryRequestDTOS = ageCategoryMapper.toDto(ageCategories);
        return ageCategoryRequestDTOS;
    }

    @Override
    public AgeCategoryRequestDTO getOneAgeCategory(Long ageCategoryId) throws AgeCategoryNotFoundByIdException {
        AgeCategory ageCategory = ageCategoryRepository.findById(ageCategoryId).orElse(null);
        if (ageCategory == null) {
            throw new AgeCategoryNotFoundByIdException("Age category with such ID does not exist.");
        }
        AgeCategoryRequestDTO ageCategoryRequestDTO = ageCategoryMapper.toDto(ageCategory);
        return ageCategoryRequestDTO;
    }

}
