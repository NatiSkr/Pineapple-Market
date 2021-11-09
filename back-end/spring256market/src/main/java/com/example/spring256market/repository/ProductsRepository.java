package com.example.spring256market.repository;

import com.example.spring256market.model.Products;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Products, Integer> {
    
}
