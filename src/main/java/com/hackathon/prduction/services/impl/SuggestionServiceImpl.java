package com.hackathon.prduction.services.impl;
import com.hackathon.prduction.domain.dto.SuggestionDTO;
import com.hackathon.prduction.domain.entity.Suggestion;
import com.hackathon.prduction.domain.mapper.SuggestionMapper;
import com.hackathon.prduction.exceptions.suggestion.SuggestionNotFoundByIdException;
import com.hackathon.prduction.repository.SuggestionRepository;
import com.hackathon.prduction.services.SuggestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SuggestionServiceImpl implements SuggestionService {
    private final SuggestionRepository suggestionRepository;
    private final SuggestionMapper suggestionMapper;


    @Override
    public SuggestionDTO createSuggestion(Suggestion suggestion) {
        return null;
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

