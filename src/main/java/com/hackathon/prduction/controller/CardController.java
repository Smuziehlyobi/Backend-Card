package com.hackathon.prduction.controller;

import com.hackathon.prduction.domain.dto.card.CardRequestDTO;
import com.hackathon.prduction.services.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cards")
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;

    @PostMapping("/new")
    public ResponseEntity<?> createCard(CardRequestDTO cardRequestDTO) {
        try {
            System.out.println("create card");
            return ResponseEntity.ok().body(cardService.createCard(cardRequestDTO));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
