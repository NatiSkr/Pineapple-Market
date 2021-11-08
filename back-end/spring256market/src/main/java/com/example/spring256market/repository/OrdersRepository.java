package com.example.spring256market.repository;

import com.example.spring256market.models.Orders;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {
    // Queries referencing Orders model
    public Orders findByOrderId(int id);

    public Orders findByUserID(int Users_id);
}
