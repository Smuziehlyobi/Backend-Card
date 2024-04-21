package com.hackathon.prduction.domain.dto.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseInfoDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String patronymic;

    private String email;
}
