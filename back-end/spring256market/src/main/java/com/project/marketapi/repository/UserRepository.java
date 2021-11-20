package com.project.marketapi.repository;

import java.util.Optional;

import com.project.marketapi.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    
    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    // User findByNombreColumna (String nombreEnModelo)
}
