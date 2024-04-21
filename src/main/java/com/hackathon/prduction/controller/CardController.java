package com.hackathon.prduction.controller;

import com.hackathon.prduction.domain.dto.card.PaymentRequestDTO;
import com.hackathon.prduction.domain.dto.card.CardResponseDTO;
import com.hackathon.prduction.domain.entity.Card;
import com.hackathon.prduction.domain.entity.User;
import com.hackathon.prduction.security.service.impl.UserServiceImpl;
import com.hackathon.prduction.services.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/cards")
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;
    private final UserServiceImpl userService;

    @GetMapping("/show")
    public ResponseEntity<?> showCard(){
        try {
            UsernamePasswordAuthenticationToken details = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
            UserDetails userDetails = (UserDetails) details.getPrincipal();
            String username = userDetails.getUsername();
            User user = userService.findByEmail(username).orElse(null);
            Card card = cardService.findByUser(user);
            CardResponseDTO cardResponseDTO = new CardResponseDTO(card.getValue(), card.getBalance(), user.getFirstName(),
                    user.getLastName(), user.getPatronymic());
            return ResponseEntity.ok().body(cardResponseDTO);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @PostMapping("/payment")
    public ResponseEntity<?> writingFromCard(@RequestBody PaymentRequestDTO paymentRequestDTO) {
        cardService.executePayment(paymentRequestDTO);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Оплата прошла успешно");
    }
}
