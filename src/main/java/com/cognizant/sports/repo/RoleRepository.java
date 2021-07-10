package com.cognizant.sports.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.sports.model.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
