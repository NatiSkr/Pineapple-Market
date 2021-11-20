package com.project.marketapi.services;

import java.util.List;

import com.project.marketapi.model.Categories;
import com.project.marketapi.payload.request.CategoriesRequest;

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
