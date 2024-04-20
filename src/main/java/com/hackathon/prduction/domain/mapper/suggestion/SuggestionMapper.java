package com.hackathon.prduction.domain.mapper.suggestion;

import com.hackathon.prduction.domain.dto.suggestion.SuggestionRequestDTO;
import com.hackathon.prduction.domain.entity.Suggestion;
import com.hackathon.prduction.domain.mapper.EntityRequestMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SuggestionMapper extends EntityRequestMapper<SuggestionRequestDTO, Suggestion> {
    @Override
    Suggestion toEntity(SuggestionRequestDTO dto);

    @Override
    SuggestionRequestDTO toDto(Suggestion entity);

    @Override
    List<Suggestion> toEntity(List<SuggestionRequestDTO> dtoList);

    @Override
    List<SuggestionRequestDTO> toDto(List<Suggestion> entityList);

}
