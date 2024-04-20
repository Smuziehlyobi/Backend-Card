package com.hackathon.prduction.domain.dto.event;

import com.hackathon.prduction.domain.entity.AgeCategory;
import com.hackathon.prduction.domain.entity.Category;
import com.hackathon.prduction.domain.entity.Event;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EventResponseDTO {
    private Long id;

    private String name;

    private Timestamp timeStart;

    private Category category;

    private AgeCategory ageCategory;

    private List<Event> eventList;
}
