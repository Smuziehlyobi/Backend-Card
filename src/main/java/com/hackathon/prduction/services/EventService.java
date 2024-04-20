package com.hackathon.prduction.services;

import com.hackathon.prduction.domain.entity.Event;

import java.util.List;

public interface EventService {
    Event findByName(String name);
    Event findById(Long id);

    List<Event> findAll();
}
