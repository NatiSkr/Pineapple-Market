package com.project.marketapi.repository;

import java.util.Optional;

import com.project.marketapi.model.Products;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Products, Integer> {

    Optional <Products> findByProductName(String productName);

    Boolean existsByProductName(String productName);
}
