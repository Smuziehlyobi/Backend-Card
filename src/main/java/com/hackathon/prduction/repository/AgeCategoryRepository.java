package com.hackathon.prduction.repository;

import com.hackathon.prduction.domain.entity.AgeCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgeCategoryRepository extends JpaRepository<AgeCategory, Long> {
}
