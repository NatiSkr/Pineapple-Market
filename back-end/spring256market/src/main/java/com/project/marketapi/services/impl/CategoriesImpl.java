package com.project.marketapi.services.impl;

import java.util.List;
import java.util.Optional;

import com.project.marketapi.model.Categories;
import com.project.marketapi.payload.CategoriesRequest;
import com.project.marketapi.repository.CategoriesRepository;
import com.project.marketapi.services.CategoriesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CategoriesImpl implements CategoriesService{

    @Autowired
    private CategoriesRepository categoriesRepository;

    // LIST
    @Override
    public ResponseEntity<List<Categories>> listCategories() {
        try {
            List<Categories> categories = categoriesRepository.findAll();
            if (categories.isEmpty()){
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(categories, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    // CREATE
    @Override
    public ResponseEntity<Categories> createCategories(CategoriesRequest newCategoriesRequest) {
        Categories category = new Categories();
        category.setCategoryName(newCategoriesRequest.getCategoryName());
        Categories newCategories = categoriesRepository.save(category);
        return new ResponseEntity<>(newCategories, HttpStatus.CREATED);
    }  

    // READ
    @Override
    public ResponseEntity<Categories> readCategories(int id) {
        Optional<Categories> category = categoriesRepository.findById(id);
        return category.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // UPDATE
    @Override
    public ResponseEntity<Categories> updateCategories(int id, CategoriesRequest newCategoriesRequest) {
        Optional<Categories> category = categoriesRepository.findById(id);
        if (category.isPresent()){
            Categories _category = category.get();
            _category.setCategoryName(newCategoriesRequest.getCategoryName());
            Categories updatedCategory = categoriesRepository.save(_category);
            return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    
    // DELETE
    @Override
    public ResponseEntity<Categories> deleteCategories(int id) {
        try {
            categoriesRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
