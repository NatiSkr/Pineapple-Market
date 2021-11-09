package com.project.marketapi.repository;

import com.project.marketapi.model.Categories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepository extends JpaRepository<Categories, Integer> {

    
}
