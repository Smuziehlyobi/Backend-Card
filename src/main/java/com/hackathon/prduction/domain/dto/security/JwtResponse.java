package com.hackathon.prduction.domain.dto.security;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class JwtResponse {

    private String accessToken;

    private String refreshToken;
}
