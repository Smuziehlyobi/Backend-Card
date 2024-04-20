package com.hackathon.prduction.repository;

import com.hackathon.prduction.domain.entity.Suggestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuggestionRepository extends JpaRepository<Suggestion, Long> {
}
