package com.hackathon.prduction.controller;

import com.hackathon.prduction.domain.dto.card.CardRequestDTO;
import com.hackathon.prduction.domain.dto.card.CardResponseDTO;
import com.hackathon.prduction.domain.entity.Card;
import com.hackathon.prduction.domain.entity.User;
import com.hackathon.prduction.security.service.impl.UserServiceImpl;
import com.hackathon.prduction.services.CardService;
import com.hackathon.prduction.services.UserService;
import com.hackathon.prduction.services.impl.CardServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/cards")
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;
    private final UserServiceImpl userService;

    @GetMapping("/show")
//    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<?> showCard(){
        try {
            UsernamePasswordAuthenticationToken details = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
            UserDetails userDetails = (UserDetails) details.getPrincipal();
            String username = userDetails.getUsername();
//            String username = details.getUsername();
            User user = userService.findByEmail(username).orElse(null);
            Card card = cardService.findByUser(user);
            CardResponseDTO cardResponseDTO = new CardResponseDTO(card.getValue(), card.getBalance(), user.getFirstName(),
                    user.getLastName(), user.getPatronymic());
            return ResponseEntity.ok().body(cardResponseDTO);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
}
