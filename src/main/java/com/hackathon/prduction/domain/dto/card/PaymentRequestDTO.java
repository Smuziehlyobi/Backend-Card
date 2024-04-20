package com.hackathon.prduction.domain.dto.card;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentRequestDTO {
    // Id карты
    private Long id;
    private Integer value;
    private String name;
}
