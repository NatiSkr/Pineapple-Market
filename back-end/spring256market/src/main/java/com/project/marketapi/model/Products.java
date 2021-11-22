package com.project.marketapi.model;

import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "products")
// Allow serialization
public class Products implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "product_name", unique = true)
    private String productName;

    @Column(name = "product_description")
    private String productDescription;

    @Column(name = "product_quantity")
    private int productQuantity;

    @Column(name = "product_unit_price")
    private double productUnitPrice;

    @Column(name = "product_picture")
    private Blob productPicture;

    // Foreign keys excepted from lazy loading

    // For category id, work only with id (int), not whole model
    @JoinColumn(name="category", insertable = false, updatable = false)
    @ManyToOne(targetEntity = Categories.class, fetch = FetchType.EAGER)
    @NotNull(message = "specified category not set")
    @JsonIgnore
    private Categories categories;

    @Column(name = "category")
    private int categoryId;

    // For user id, work only with id (int), not whole model
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @NotNull(message = "specified user not set")
    @JsonIgnore
    private User user;

    @Column(name="user_id")
    private int userId;

    public Products() {
    }
    // Empty constructor

    public Products(int id, String productName, String productDescription, int productQuantity, double productUnitPrice,
            Blob productPicture,int categoryId, int userId) {
        this.id = id;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productQuantity = productQuantity;
        this.productUnitPrice = productUnitPrice;
        this.productPicture = productPicture;
        this.categoryId = categoryId;
        this.userId = userId;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Blob getProductPicture() {
        return this.productPicture;
    }

    public void setProductPicture(Blob productPicture) {
        this.productPicture = productPicture;
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
