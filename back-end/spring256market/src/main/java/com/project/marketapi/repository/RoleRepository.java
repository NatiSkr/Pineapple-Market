package com.project.marketapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import com.project.marketapi.model.ERole;
import com.project.marketapi.model.Role;

public interface RoleRepository extends JpaRepository<Role,Integer> {

    Optional<Role> findByName(ERole name);
}
