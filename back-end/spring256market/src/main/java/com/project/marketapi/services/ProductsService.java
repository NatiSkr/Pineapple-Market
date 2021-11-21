package com.project.marketapi.services;

import java.util.List;

import com.project.marketapi.model.Products;
import com.project.marketapi.payload.request.ProductsRequest;

import org.springframework.http.ResponseEntity;


public interface ProductsService {
    // Bring partial data from payload - do not interact directly with table
    ResponseEntity<List<Products>> listProducts();

    // CRUD
    ResponseEntity<Products> createProducts(ProductsRequest newProductsRequest);
    ResponseEntity<Products> readProducts(String productName);
    ResponseEntity<Products> updateProducts(int id, ProductsRequest newProductsRequest);
    ResponseEntity<Products> deleteProducts(int id);
}
