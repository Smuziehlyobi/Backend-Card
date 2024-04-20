package com.hackathon.prduction.repository;

import com.hackathon.prduction.domain.entity.UserEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEventRepository extends JpaRepository<UserEvent, Long> {
}
