package com.hackathon.prduction.domain.dto.user;

import com.hackathon.prduction.domain.entity.Event;
import com.hackathon.prduction.domain.entity.Role;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserResponseDTO {

    private String firstName;

    private String lastName;

    private String patronymic;

    private String password;

    private String email;

    private Role role;

    private List<Event> events;
}
