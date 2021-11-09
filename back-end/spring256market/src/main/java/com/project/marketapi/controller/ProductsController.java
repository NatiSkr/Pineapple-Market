package com.project.marketapi.controller;

import java.util.List;

import javax.validation.Valid;

import com.project.marketapi.model.Products;
import com.project.marketapi.payload.ProductsRequest;
import com.project.marketapi.services.ProductsService;

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
@RequestMapping("/api") // handle only /api requests

public class ProductsController {

    @Autowired
    private ProductsService productsService;

    // LIST
    @GetMapping(value="/products/all")
    public ResponseEntity<List<Products>> listProducts(){
        return productsService.listProducts();
    }

   // CREATE
   @PostMapping(value="/products")
   public ResponseEntity<Products> createProducts(@Valid @RequestBody ProductsRequest newProductsRequest) {
       return productsService.createProducts(newProductsRequest);
   }
   
   // READ
   @GetMapping(value="/products/{id}")
   public ResponseEntity<Products> readProducts(@PathVariable("id")int id) {
       return productsService.readProducts(id);
   }

   // UPDATE
   @PutMapping(value="/products/{id}")
   public ResponseEntity<Products> updateProducts(@PathVariable("id") int id, @RequestBody ProductsRequest newProductsRequest) {
       return productsService.updateProducts(id, newProductsRequest);
   }

   // DELETE
   @DeleteMapping(value="/products/{id}")
   public ResponseEntity<Products> deleteProducts(@PathVariable("id") int id) {
       return productsService.deleteProducts(id);
   } 
}
