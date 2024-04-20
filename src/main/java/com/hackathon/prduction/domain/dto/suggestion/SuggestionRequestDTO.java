package com.hackathon.prduction.domain.dto.suggestion;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SuggestionRequestDTO {
    private byte[] image;
    private String header;
    private String description;
}
