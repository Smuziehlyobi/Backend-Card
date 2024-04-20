package com.hackathon.prduction.domain.dto.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class JwtWithCardResponseDTO {

    private String accessToken;

    private String refreshToken;

    private String value;

    private Long balance;

    private String firstName;

    private String lastName;

    private String patronymic;



}
