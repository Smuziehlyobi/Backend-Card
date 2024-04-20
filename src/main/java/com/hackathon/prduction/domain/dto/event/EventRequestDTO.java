package com.hackathon.prduction.domain.dto.event;

import com.hackathon.prduction.domain.entity.AgeCategory;
import com.hackathon.prduction.domain.entity.Category;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EventRequestDTO {
    private String name;

    private Timestamp timeStart;

    private Long categoryId;

    private Long ageCategoryId;
}
