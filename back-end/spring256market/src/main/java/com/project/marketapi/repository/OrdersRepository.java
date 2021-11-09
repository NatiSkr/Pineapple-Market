package com.project.marketapi.repository;

import com.project.marketapi.model.Orders;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {
    
}
