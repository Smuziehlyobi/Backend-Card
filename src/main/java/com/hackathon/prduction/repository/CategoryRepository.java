package com.hackathon.prduction.repository;

import com.hackathon.prduction.domain.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
