package com.example.spring256market.repository;

import com.example.spring256market.model.Categories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepository extends JpaRepository<Categories, Integer> {

    
}
