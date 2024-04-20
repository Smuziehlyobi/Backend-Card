package com.hackathon.prduction.domain.dto.security;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AuthDTO {

    private String username;

    private String password;
}
