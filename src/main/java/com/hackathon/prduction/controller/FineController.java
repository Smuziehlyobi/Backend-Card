package com.hackathon.prduction.controller;

import com.hackathon.prduction.services.impl.FineServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/fine")
public class FineController {

    private final FineServiceImpl fineService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllFine () {
        return ResponseEntity.ok().body(fineService.getAll());
    }

}
