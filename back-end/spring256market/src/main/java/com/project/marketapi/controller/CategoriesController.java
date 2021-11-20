package com.project.marketapi.controller;

import java.util.List;

import javax.validation.Valid;

import com.project.marketapi.model.Categories;
import com.project.marketapi.payload.request.CategoriesRequest;
import com.project.marketapi.services.CategoriesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(value="/api") // handle only /api requests

public class CategoriesController {

    @Autowired
    private CategoriesService categoriesService;

    // LIST
    @GetMapping(value="/categories/all")
    public ResponseEntity<List<Categories>> listCategories(){
        return categoriesService.listCategories();
    }

    // CREATE
    @PostMapping(value="/categories")
    public ResponseEntity<Categories> createCategories(@Valid @RequestBody CategoriesRequest newCategoriesRequest) {
        return categoriesService.createCategories(newCategoriesRequest);
    }
    
    // READ
    @GetMapping(value="/categories/{id}")
    public ResponseEntity<Categories> readCategories(@PathVariable("id")int id) {
        return categoriesService.readCategories(id);
    }

    // UPDATE
    @PutMapping(value="/categories/{id}")
    public ResponseEntity<Categories> updateCategories(@PathVariable("id") int id, @RequestBody CategoriesRequest newCategoriesRequest) {
        return categoriesService.updateCategories(id, newCategoriesRequest);
    }

    // DELETE
    @DeleteMapping(value="/categories/{id}")
    public ResponseEntity<Categories> deleteCategories(@PathVariable("id") int id) {
        return categoriesService.deleteCategories(id);
    }
    
}
