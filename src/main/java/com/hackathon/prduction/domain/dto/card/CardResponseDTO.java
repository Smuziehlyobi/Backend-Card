package com.hackathon.prduction.domain.dto.card;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CardResponseDTO {
    private String value;

    private Long balance;

    private String firstName;

    private String lastName;

    private String patronymic;

}
