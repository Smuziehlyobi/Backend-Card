package com.hackathon.prduction.domain.dto.card;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CardRequestDTO {
    private String value;

    private Long balance;
}
