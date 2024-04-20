package com.hackathon.prduction.domain.mapper;

import com.hackathon.prduction.domain.dto.EventDTO;
import com.hackathon.prduction.domain.entity.Event;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EventMapper extends EntityMapper<EventDTO, Event> {
    @Override
    Event toEntity(EventDTO dto);

    @Override
    EventDTO toDto(Event entity);

    @Override
    List<Event> toEntity(List<EventDTO> dtoList);

    @Override
    List<EventDTO> toDto(List<Event> entityList);

    @Override
    void partialUpdate(Event entity, EventDTO dto);
}
