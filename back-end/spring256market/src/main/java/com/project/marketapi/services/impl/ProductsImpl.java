package com.project.marketapi.services.impl;

import java.util.List;
import java.util.Optional;

import com.project.marketapi.model.Products;
import com.project.marketapi.payload.ProductsRequest;
import com.project.marketapi.repository.ProductsRepository;
import com.project.marketapi.services.ProductsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductsImpl implements ProductsService {
    
    @Autowired
    private ProductsRepository productsRepository;

    // LIST
    @Override
    public ResponseEntity<List<Products>> listProducts() {
        try {
            List<Products> products = productsRepository.findAll();
            if (products.isEmpty()){
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    // CREATE
    @Override
    public ResponseEntity<Products> createProducts(ProductsRequest newProductsRequest) {
        Products product = new Products();
        product.setProductName(newProductsRequest.getProductName());
        product.setProductDescription(newProductsRequest.getProductName());
        product.setProductQuantity(newProductsRequest.getProductQuantity());
        product.setProductUnitPrice(newProductsRequest.getProductUnitPrice());
        Products newProducts = productsRepository.save(product);
        return new ResponseEntity<>(newProducts, HttpStatus.CREATED);
    }

    // READ
    @Override
    public ResponseEntity<Products> readProducts(int id) {
        Optional<Products> product = productsRepository.findById(id);
        return product.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // UPDATE
    @Override
    public ResponseEntity<Products> updateProducts(int id, ProductsRequest newProductsRequest) {
        Optional<Products> product = productsRepository.findById(id);
        if (product.isPresent()){
            Products _product = product.get();
            _product.setProductName(newProductsRequest.getProductName());
            _product.setProductDescription(newProductsRequest.getProductName());
            _product.setProductQuantity(newProductsRequest.getProductQuantity());
            _product.setProductUnitPrice(newProductsRequest.getProductUnitPrice());
            Products updatedProduct = productsRepository.save(_product);
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    // DELETE
    @Override
    public ResponseEntity<Products> deleteProducts(int id) {
        try {
            productsRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
