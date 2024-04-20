package com.hackathon.prduction.services.impl;

import com.hackathon.prduction.domain.dto.event.EventRequestDTO;
import com.hackathon.prduction.domain.entity.Event;
import com.hackathon.prduction.domain.entity.User;
import com.hackathon.prduction.domain.entity.UserEvent;
import com.hackathon.prduction.repository.UserEventRepository;
import com.hackathon.prduction.security.service.impl.UserServiceImpl;
import com.hackathon.prduction.services.EventService;
import com.hackathon.prduction.services.UserEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class UserEventServiceImpl implements UserEventService {
    private final UserEventRepository eventRepository;

    private final UserServiceImpl userService;

    private final EventService eventService;

    @Override
    public void executeRegistration(EventRequestDTO eventRequestDTO){
        UsernamePasswordAuthenticationToken details = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) details.getPrincipal();
        String username = userDetails.getUsername();
        User user = userService.findByEmail(username).orElse(null);
        Event event = eventService.findById(eventRequestDTO.getId());
        UserEvent userEvent = new UserEvent();
        userEvent.setUser(user);
        userEvent.setEvent(event);
        eventRepository.save(userEvent);
    }

}
