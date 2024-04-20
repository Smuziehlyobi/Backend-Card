package com.hackathon.prduction.domain.dto.suggestion;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SuggestionResponseDTO {
    private Long id;
    private byte[] image;
    private String header;
    private String description;
}
