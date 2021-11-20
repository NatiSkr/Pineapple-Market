package com.project.marketapi.payload.request;

import com.project.marketapi.model.Categories;
import com.project.marketapi.model.User;

import lombok.Data;

@Data
public class ProductsRequest {
    // Atributes to get from table
    private String productName;
    private String productDescription;
    private int productQuantity;
    private double productUnitPrice;
    private Categories categories;
    private User user;
    // Pending preview image

    // Filled constructors & Getters and Setters
    public ProductsRequest(String productName, String productDescription, int productQuantity, double productUnitPrice, Categories categories, User user) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productQuantity = productQuantity;
        this.productUnitPrice = productUnitPrice;
        this.categories = categories;
        this.user = user;
    }
    
    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return this.productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getProductQuantity() {
        return this.productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public double getProductUnitPrice() {
        return this.productUnitPrice;
    }

    public void setProductUnitPrice(double productUnitPrice) {
        this.productUnitPrice = productUnitPrice;
    }

    public Categories getCategories() {
        return this.categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
