package com.hackathon.prduction.domain.mapper.card;

import com.hackathon.prduction.domain.dto.card.CardResponseDTO;
import com.hackathon.prduction.domain.entity.Card;
import com.hackathon.prduction.domain.mapper.EntityResponseMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")

public interface CardResponseMapper extends EntityResponseMapper<CardResponseDTO, Card> {
    @Override
    Card toEntity(CardResponseDTO dto);

    @Override
    CardResponseDTO toDto(Card entity);

    @Override
    List<Card> toEntity(List<CardResponseDTO> dtoList);

    @Override
    List<CardResponseDTO> toDto(List<Card> entityList);
}
