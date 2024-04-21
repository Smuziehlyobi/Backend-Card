package com.hackathon.prduction.controller;

import com.hackathon.prduction.domain.entity.User;
import com.hackathon.prduction.security.service.impl.UserServiceImpl;
import com.hackathon.prduction.services.impl.TransactionServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor

public class TransactionController {

    private final UserServiceImpl userService;

    private final TransactionServiceImpl transactionService;

    @GetMapping("/all")
    public ResponseEntity<?> showAllTransaction (){
        UsernamePasswordAuthenticationToken details = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) details.getPrincipal();
        String username = userDetails.getUsername();
        User user = userService.findByEmail(username).orElse(null);
        return ResponseEntity.ok().body(transactionService.getAllTransactionsByUser(user));
    }
}
