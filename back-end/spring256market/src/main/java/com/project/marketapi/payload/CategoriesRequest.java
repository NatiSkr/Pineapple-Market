package com.project.marketapi.payload;

import lombok.Data;

@Data
public class CategoriesRequest {
    // Attributes
    private String categoryName;

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
