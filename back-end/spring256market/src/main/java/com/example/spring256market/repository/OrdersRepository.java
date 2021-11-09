package com.example.spring256market.repository;

import com.example.spring256market.model.Orders;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {
    
}
