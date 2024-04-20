package com.hackathon.prduction.controller;

import com.hackathon.prduction.domain.dto.event.EventRequestDTO;
import com.hackathon.prduction.domain.entity.Event;
import com.hackathon.prduction.services.EventService;
import com.hackathon.prduction.services.impl.EventServiceImpl;
import com.hackathon.prduction.services.impl.UserEventServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
public class EventController {

    private final UserEventServiceImpl userEventService;

    private final EventService eventService;

    @PostMapping("/reg")
    public ResponseEntity<?> registrationToEvent(@RequestBody EventRequestDTO eventRequestDTO){
        userEventService.executeRegistration(eventRequestDTO);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Запись прошла успешно");
    }

        @GetMapping("/all")
    public ResponseEntity<?> showAll(){
        return ResponseEntity.ok().body(eventService.findAll());
    }
}
