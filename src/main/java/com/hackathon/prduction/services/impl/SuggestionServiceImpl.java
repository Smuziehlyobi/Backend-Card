package com.hackathon.prduction.services.impl;
import com.hackathon.prduction.domain.dto.suggestion.SuggestionRequestDTO;
import com.hackathon.prduction.domain.entity.Suggestion;
import com.hackathon.prduction.domain.mapper.suggestion.SuggestionMapper;
import com.hackathon.prduction.exceptions.suggestion.SuggestionNotFoundByIdException;
import com.hackathon.prduction.repository.SuggestionRepository;
import com.hackathon.prduction.services.SuggestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SuggestionServiceImpl implements SuggestionService {
    private final SuggestionRepository suggestionRepository;
    private final SuggestionMapper suggestionMapper;


    @Override
    public SuggestionRequestDTO createSuggestion(Suggestion suggestion) {
        return null;
    }

    @Override
    public void deleteSuggestion(Long suggestionId) throws SuggestionNotFoundByIdException {
        Suggestion suggestion = suggestionRepository.findById(suggestionId)
                .orElseThrow(() -> new SuggestionNotFoundByIdException("Suggestion with such ID does not exist."));
        suggestionRepository.delete(suggestion);
    }

    @Override
    public List<SuggestionRequestDTO> getAllSuggestions() {
        List<Suggestion> suggestions = suggestionRepository.findAll();
        List<SuggestionRequestDTO> suggestionRequestDTOS = suggestionMapper.toDto(suggestions);
        return suggestionRequestDTOS;
    }

    @Override
    public SuggestionRequestDTO getOneSuggestion(Long suggestionId) throws SuggestionNotFoundByIdException {
        Suggestion suggestion = suggestionRepository.findById(suggestionId)
                .orElseThrow(() -> new SuggestionNotFoundByIdException("Suggestion with such ID does not exist."));
        return suggestionMapper.toDto(suggestion);
    }
}

