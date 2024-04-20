package com.hackathon.prduction.repository;

import com.hackathon.prduction.domain.entity.AgeCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AgeCategoryRepository extends JpaRepository<AgeCategory, Long> {
}
