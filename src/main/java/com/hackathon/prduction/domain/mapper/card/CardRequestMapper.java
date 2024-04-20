package com.hackathon.prduction.domain.mapper.card;

import com.hackathon.prduction.domain.dto.card.CardRequestDTO;
import com.hackathon.prduction.domain.entity.Card;
import com.hackathon.prduction.domain.mapper.EntityRequestMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CardRequestMapper extends EntityRequestMapper<CardRequestDTO, Card> {
    @Override
    Card toEntity(CardRequestDTO dto);

    @Override
    CardRequestDTO toDto(Card entity);

    @Override
    List<Card> toEntity(List<CardRequestDTO> dtoList);

    @Override
    List<CardRequestDTO> toDto(List<Card> entityList);

}
