package com.hackathon.prduction.services.impl;

import com.hackathon.prduction.domain.dto.event.EventResponseDTO;
import com.hackathon.prduction.domain.entity.Event;
import com.hackathon.prduction.domain.entity.User;
import com.hackathon.prduction.domain.mapper.event.EventResponseMapper;
import com.hackathon.prduction.exceptions.event.EventNotFoundException;
import com.hackathon.prduction.repository.EventRepository;
import com.hackathon.prduction.repository.UserRepository;
import com.hackathon.prduction.services.EventService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    private final UserRepository userRepository;

    private final EventResponseMapper eventMapper;

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

    @Transactional
    public List<EventResponseDTO> findOwnEvent() {
        UsernamePasswordAuthenticationToken details = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) details.getPrincipal();
        String username = userDetails.getUsername();
        User user = userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("You are not registred"));
        List<Event> list = new ArrayList<>(user.getEvents());
        return eventMapper.toDto(list);
    }
}
