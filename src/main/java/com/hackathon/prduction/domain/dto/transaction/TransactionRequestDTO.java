package com.hackathon.prduction.domain.dto.transaction;

import com.hackathon.prduction.domain.entity.User;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TransactionRequestDTO {
    private String name;

    private Integer value;

    private Timestamp time;

    private User user;
}
