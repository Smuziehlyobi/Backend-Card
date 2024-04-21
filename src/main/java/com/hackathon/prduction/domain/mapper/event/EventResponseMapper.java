package com.hackathon.prduction.domain.mapper.event;

import com.hackathon.prduction.domain.dto.event.EventResponseDTO;
import com.hackathon.prduction.domain.entity.Event;
import com.hackathon.prduction.domain.mapper.EntityResponseMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EventResponseMapper extends EntityResponseMapper<EventResponseDTO, Event> {
    @Override
    Event toEntity(EventResponseDTO dto);

    @Override
    EventResponseDTO toDto(Event entity);

    @Override
    List<Event> toEntity(List<EventResponseDTO> dtoList);

    @Override
    List<EventResponseDTO> toDto(List<Event> entityList);
}
