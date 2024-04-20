package com.hackathon.prduction.domain.mapper;

import com.hackathon.prduction.domain.dto.SuggestionDTO;
import com.hackathon.prduction.domain.entity.Suggestion;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SuggestionMapper extends EntityMapper<SuggestionDTO, Suggestion> {
    @Override
    Suggestion toEntity(SuggestionDTO dto);

    @Override
    SuggestionDTO toDto(Suggestion entity);

    @Override
    List<Suggestion> toEntity(List<SuggestionDTO> dtoList);

    @Override
    List<SuggestionDTO> toDto(List<Suggestion> entityList);

}
