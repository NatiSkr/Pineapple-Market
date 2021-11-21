package com.project.marketapi.payload.request;

import lombok.Data;

@Data
public class CategoriesRequest {
    // Attributes
    private String categoryName;

    // Empty constructor for deserialisation
    public CategoriesRequest() {
    }

    // Filled constructor, gettters and setters
    public CategoriesRequest(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

}
