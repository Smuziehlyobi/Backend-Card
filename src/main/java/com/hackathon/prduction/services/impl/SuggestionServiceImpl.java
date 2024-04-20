package com.hackathon.prduction.services.impl;
import com.hackathon.prduction.domain.dto.SuggestionDTO;
import com.hackathon.prduction.domain.entity.Suggestion;
import com.hackathon.prduction.domain.mapper.SuggestionMapper;
import com.hackathon.prduction.exceptions.suggestion.SuggestionNotFoundByIdException;
import com.hackathon.prduction.repository.SuggestionRepository;
import com.hackathon.prduction.services.SuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuggestionServiceImpl implements SuggestionService {
    private final SuggestionService suggestionService;
    private final SuggestionRepository suggestionRepository;
    private final SuggestionMapper suggestionMapper;

    @Autowired
    public SuggestionServiceImpl(SuggestionService suggestionService, SuggestionRepository suggestionRepository, SuggestionMapper suggestionMapper) {
        this.suggestionService = suggestionService;
        this.suggestionRepository = suggestionRepository;
        this.suggestionMapper = suggestionMapper;
    }

    @Override
    public SuggestionDTO createSuggestion(Suggestion suggestion) {
        SuggestionDTO suggestionDTO = suggestionMapper.toDto(suggestion);
        suggestionRepository.save(suggestion);
        return suggestionDTO;
    }

    @Override
    public void deleteSuggestion(Long suggestionId) throws SuggestionNotFoundByIdException {
        Suggestion suggestion = suggestionRepository.findById(suggestionId).orElse(null);
        if (suggestion == null) {
            throw new SuggestionNotFoundByIdException("Suggestion with such ID does not exist.");
        }
        suggestionRepository.delete(suggestion);
    }

    @Override
    public List<SuggestionDTO> getAllSuggestions() {
        List<Suggestion> suggestions = suggestionRepository.findAll();
        List<SuggestionDTO> suggestionDTOs = suggestionMapper.toDto(suggestions);
        return suggestionDTOs;
    }

    @Override
    public SuggestionDTO getOneSuggestion(Long suggestionId) throws SuggestionNotFoundByIdException {
        Suggestion suggestion = suggestionRepository.findById(suggestionId).orElse(null);
        if (suggestion == null) {
            throw new SuggestionNotFoundByIdException("Suggestion with such ID does not exist.");
        }
        SuggestionDTO suggestionDTO = suggestionMapper.toDto(suggestion);
        return suggestionDTO;
    }
}

