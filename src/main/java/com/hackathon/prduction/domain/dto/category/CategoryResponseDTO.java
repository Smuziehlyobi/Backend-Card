package com.hackathon.prduction.domain.dto.category;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryResponseDTO {
    private Long id;
    private String name;
}
