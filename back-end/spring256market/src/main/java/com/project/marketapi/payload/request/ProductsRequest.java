package com.project.marketapi.payload.request;

import lombok.Data;


@Data
public class ProductsRequest {
    // Atributes to get from table
    private String productName;
    private String productDescription;
    private int productQuantity;
    private double productUnitPrice;
    private int categoryId;
    private int userId;
    // Pending preview image

    // Filled constructor, gettters and setters
    public ProductsRequest() {
    }

    // Filled constructors & Getters and Setters
    public ProductsRequest(String productName, String productDescription, int productQuantity, double productUnitPrice, 
    int categoryId, int userId) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productQuantity = productQuantity;
        this.productUnitPrice = productUnitPrice;
        this.categoryId = categoryId;
        this.userId = userId;
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

    public int getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
