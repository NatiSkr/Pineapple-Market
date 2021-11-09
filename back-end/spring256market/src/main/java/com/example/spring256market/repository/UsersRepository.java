package com.example.spring256market.repository;

import com.example.spring256market.model.Users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Integer> {
    
}
