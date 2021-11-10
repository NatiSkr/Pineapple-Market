package com.project.marketapi.repository;

import com.project.marketapi.model.Users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Integer> {
    
}
