package com.example.spring256market.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Table(name = "categories")
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Category Id", nullable = false, unique = true)
    private int id;

    @Column(name = "Category name", nullable = false, unique = true)
    private String categoryName;

    public Categories() {
    }
    // Empty constructor

    public Categories(int id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }

    /*
     * Getters and Setters
     */
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

}
