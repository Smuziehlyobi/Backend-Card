package com.hackathon.prduction.domain.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SuggestionDTO {
    private byte[] image;
    private String header;
    private String description;
}
