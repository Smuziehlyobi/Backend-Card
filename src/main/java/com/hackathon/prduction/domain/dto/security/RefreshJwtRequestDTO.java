package com.hackathon.prduction.domain.dto.security;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RefreshJwtRequestDTO {

    private String refreshToken;
}
