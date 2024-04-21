package com.hackathon.prduction.services.impl;

import com.hackathon.prduction.domain.entity.Event;
import com.hackathon.prduction.exceptions.card.CardNotFoundByIdException;
import com.hackathon.prduction.exceptions.event.EventNotFoundException;
import com.hackathon.prduction.repository.EventRepository;
import com.hackathon.prduction.services.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    @Override
    public Event findByName(String name) {
        return eventRepository.findByName(name).orElseThrow(() -> new EventNotFoundException("Event not found"));
    }
    @Override
    public Event findById(Long id) {
        return eventRepository.findById(id).orElseThrow(() -> new EventNotFoundException("Event not found"));
    }
    @Override
    public List<Event> findAll(){
        return eventRepository.findAll();
    }
}
