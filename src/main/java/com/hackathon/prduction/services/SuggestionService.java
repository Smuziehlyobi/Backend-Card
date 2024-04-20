package com.hackathon.prduction.services;
import com.hackathon.prduction.domain.dto.SuggestionDTO;
import com.hackathon.prduction.domain.entity.Suggestion;
import com.hackathon.prduction.exceptions.suggestion.SuggestionNotFoundByIdException;

import java.util.List;

public interface SuggestionService {
    SuggestionDTO createSuggestion(Suggestion suggestion);
    void deleteSuggestion(Long suggestionId) throws SuggestionNotFoundByIdException;
    List<SuggestionDTO> getAllSuggestions();
    SuggestionDTO getOneSuggestion(Long suggestionId) throws SuggestionNotFoundByIdException;
}

