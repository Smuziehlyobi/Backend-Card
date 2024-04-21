package com.hackathon.prduction.services;

import com.hackathon.prduction.domain.dto.event.EventRequestDTO;

public interface UserEventService {
    void executeRegistration(EventRequestDTO eventRequestDTO);
}
