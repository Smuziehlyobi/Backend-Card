package com.hackathon.prduction.domain.mapper;

import com.hackathon.prduction.domain.dto.CardDTO;
import com.hackathon.prduction.domain.entity.Card;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CardMapper extends EntityMapper<CardDTO, Card> {
    @Override
    Card toEntity(CardDTO dto);

    @Override
    CardDTO toDto(Card entity);

    @Override
    List<Card> toEntity(List<CardDTO> dtoList);

    @Override
    List<CardDTO> toDto(List<Card> entityList);

    @Override
    void partialUpdate(Card entity, CardDTO dto);
}
