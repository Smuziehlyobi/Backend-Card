package com.hackathon.prduction.controller;

import com.hackathon.prduction.domain.dto.card.CardRequestDTO;
import com.hackathon.prduction.domain.dto.card.CardResponseDTO;
import com.hackathon.prduction.exceptions.card.CardNotFoundByIdException;
import com.hackathon.prduction.services.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;

    @PostMapping("/new")
    public ResponseEntity<?> createCard(CardRequestDTO cardRequestDTO) {
        try {
            return ResponseEntity.ok().body(cardService.createCard(cardRequestDTO));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllCards() {
        try {
            List<CardResponseDTO> cardResponseDTOS = cardService.getAllCards();
            return ResponseEntity.ok().body(cardResponseDTOS);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{cardId}")
    public ResponseEntity<?> deleteCardById(@PathVariable Long cardId) {
        try{
            cardService.deleteCard(cardId);
            return ResponseEntity.ok().body(String.format("Card with ID : %d was deleted", cardId));
        } catch (CardNotFoundByIdException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{cardId}")
    public ResponseEntity<?> getCardById(@PathVariable Long cardId) {
        try{
            return ResponseEntity.ok().body(cardService.getOneCard(cardId));
        } catch (CardNotFoundByIdException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
