package com.hackathon.prduction.repository;

import com.hackathon.prduction.domain.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {
}
