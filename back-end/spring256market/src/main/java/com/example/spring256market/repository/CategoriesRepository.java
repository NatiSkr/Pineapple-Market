package com.example.spring256market.repository;

import com.example.spring256market.models.Categories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepository extends JpaRepository<Categories, Integer> {
    // Queries referencing Categories model
    public Categories findByCategoryName(String categoryName);
}
