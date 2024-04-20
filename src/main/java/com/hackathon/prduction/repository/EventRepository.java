package com.hackathon.prduction.repository;

import com.hackathon.prduction.domain.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
