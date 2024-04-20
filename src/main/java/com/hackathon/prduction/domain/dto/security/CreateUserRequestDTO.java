package com.hackathon.prduction.domain.dto.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CreateUserRequestDTO {

    private String firstName;

    private String lastName;

    private String patronymic;

    private String password;

    private String repeatPassword;

    private String email;

}
