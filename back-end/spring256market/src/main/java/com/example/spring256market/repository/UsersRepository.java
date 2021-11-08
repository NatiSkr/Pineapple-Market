package com.example.spring256market.repository;

import com.example.spring256market.models.Users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Integer> {
    // Queries referencing Users model
    public Users findByUsername(String UserName);
}
