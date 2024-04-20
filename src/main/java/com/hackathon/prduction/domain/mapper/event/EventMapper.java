package com.hackathon.prduction.domain.mapper.event;

import com.hackathon.prduction.domain.dto.event.EventRequestDTO;
import com.hackathon.prduction.domain.entity.Event;
import com.hackathon.prduction.domain.mapper.EntityRequestMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EventMapper extends EntityRequestMapper<EventRequestDTO, Event> {
    @Override
    Event toEntity(EventRequestDTO dto);

    @Override
    EventRequestDTO toDto(Event entity);

    @Override
    List<Event> toEntity(List<EventRequestDTO> dtoList);

    @Override
    List<EventRequestDTO> toDto(List<Event> entityList);

}
