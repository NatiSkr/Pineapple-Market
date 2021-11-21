package com.project.marketapi.controller;

import java.util.List;

import javax.validation.Valid;

import com.project.marketapi.model.Products;
import com.project.marketapi.payload.request.ProductsRequest;
import com.project.marketapi.services.ProductsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api") // handle only /api requests


public class ProductsController {

    @Autowired
    private ProductsService productsService;

    // LIST
    @GetMapping(value="/products/all")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity<List<Products>> listProducts(){
        return productsService.listProducts();
    }

   // CREATE
   @PostMapping(value="/products")
   @PreAuthorize("hasRole('ROLE_ADMIN')")
   public ResponseEntity<Products> createProducts(@Valid @RequestBody ProductsRequest newProductsRequest) {
       return productsService.createProducts(newProductsRequest);
   }
   
   // READ
   @GetMapping(value="/products/{id}")
   @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
   public ResponseEntity<Products> readProducts(@PathVariable("id")int id) {
       return productsService.readProducts(id);
   }

   // UPDATE
   @PutMapping(value="/products/{id}")
   @PreAuthorize("hasRole('ROLE_ADMIN')")
   public ResponseEntity<Products> updateProducts(@PathVariable("id") int id, @RequestBody ProductsRequest newProductsRequest) {
       return productsService.updateProducts(id, newProductsRequest);
   }

   // DELETE
   @DeleteMapping(value="/products/{id}")
   @PreAuthorize("hasRole('ROLE_ADMIN')")
   public ResponseEntity<Products> deleteProducts(@PathVariable("id") int id) {
       return productsService.deleteProducts(id);
   } 
}
