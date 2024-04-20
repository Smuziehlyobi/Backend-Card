package com.hackathon.prduction.controller;

import com.hackathon.prduction.domain.dto.security.AuthDTO;
import com.hackathon.prduction.domain.dto.security.CreateUserRequestDTO;
import com.hackathon.prduction.domain.dto.security.RefreshJwtRequestDTO;
import com.hackathon.prduction.domain.entity.User;
import com.hackathon.prduction.security.service.AuthService;
import com.hackathon.prduction.services.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> userRegistration( @RequestBody CreateUserRequestDTO createUserRequestDTO) {
        try {
            return ResponseEntity.ok().body(authService.registration(createUserRequestDTO));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public  ResponseEntity<?> userLogin(@RequestBody AuthDTO authDTO){
        try {
            return ResponseEntity.ok().body(authService.login(authDTO));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/refresh")
    public  ResponseEntity<?> refreshToken(@RequestBody RefreshJwtRequestDTO refreshJwtRequestDTO){
        try {
            return ResponseEntity.ok().body(authService.refresh(refreshJwtRequestDTO.getRefreshToken()));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/access-token")
    public ResponseEntity<?> getAccessToken(@RequestBody RefreshJwtRequestDTO refreshJwtRequestDTO){
        try {
            return ResponseEntity.ok().body(authService.getAccessToken(refreshJwtRequestDTO.getRefreshToken()));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

 }
