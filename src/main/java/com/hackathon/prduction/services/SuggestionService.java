package com.hackathon.prduction.services;
import com.hackathon.prduction.domain.dto.suggestion.SuggestionRequestDTO;
import com.hackathon.prduction.domain.entity.Suggestion;
import com.hackathon.prduction.exceptions.suggestion.SuggestionNotFoundByIdException;

import java.util.List;

public interface SuggestionService {
    SuggestionRequestDTO createSuggestion(Suggestion suggestion);
    void deleteSuggestion(Long suggestionId) throws SuggestionNotFoundByIdException;
    List<SuggestionRequestDTO> getAllSuggestions();
    SuggestionRequestDTO getOneSuggestion(Long suggestionId) throws SuggestionNotFoundByIdException;
}

