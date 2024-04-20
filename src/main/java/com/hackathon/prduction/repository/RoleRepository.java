package com.hackathon.prduction.repository;

import com.hackathon.prduction.domain.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
