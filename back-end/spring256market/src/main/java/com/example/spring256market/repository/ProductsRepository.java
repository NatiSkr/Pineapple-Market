package com.example.spring256market.repository;

import com.example.spring256market.models.Products;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Products, Integer> {
    // Queries referencing Products model
    public Products findByProductName(String productName);

    public Products findByCategoryName(String Categories_id);
}
