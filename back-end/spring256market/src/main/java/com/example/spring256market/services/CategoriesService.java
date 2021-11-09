package com.example.spring256market.services;

import java.util.List;

import com.example.spring256market.model.Categories;
import com.example.spring256market.payload.CategoriesRequest;
import org.springframework.http.ResponseEntity;


public interface CategoriesService {
    // Bring partial data from payload - do not interact directly with table
    ResponseEntity<List<Categories>> listCategories();

    // CRUD
    ResponseEntity<Categories> createCategories(CategoriesRequest newCategoriesRequest);
    ResponseEntity<Categories> readCategories(int id);
    ResponseEntity<Categories> updateCategories(int id, CategoriesRequest newCategoriesRequest);
    ResponseEntity<Categories> deleteCategories(int id);
}
