package com.hackathon.prduction.domain.dto.card;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CardResponseDTO {
    private Long id;
    private String value;
    private String balance;
}
