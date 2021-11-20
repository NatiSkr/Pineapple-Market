package com.project.marketapi.repository;

import com.project.marketapi.model.Products;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Products, Integer> {
    public Products findByProductName(String productName);
}
