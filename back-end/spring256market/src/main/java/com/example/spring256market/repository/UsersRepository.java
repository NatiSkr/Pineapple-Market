package com.example.spring256market.repository;

import com.example.spring256market.models.Users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Integer> {
    // Queries referencing Users model
    public Users findByFirstName(String firstName);

    public Users findByUsername(String UserName);

    public Users findByEmail(String email);

    public Users findByPassword(String password);
}
