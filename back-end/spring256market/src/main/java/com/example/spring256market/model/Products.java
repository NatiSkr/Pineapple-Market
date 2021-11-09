package com.example.spring256market.model;

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

@Entity
@Table(name = "products")
// Allow serialization
public class Products implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_description")
    private String productDescription;

    @Column(name = "product_quantity")
    private int productQuantity;

    @Column(name = "product_unit_price")
    private double productUnitPrice;

    @Column(name = "product_picture")
    private Blob productPicture;

    // Foreign key excepted from lazy loading
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Categories_id")
    private Categories Categories;
    // Reference to Categories table entity insied Categories class

    public Products() {
    }
    // Empty constructor

    public Products(int id, String productName, String productDescription, int productQuantity, double productUnitPrice,
            Blob productPicture, Categories Categories) {
        this.id = id;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productQuantity = productQuantity;
        this.productUnitPrice = productUnitPrice;
        this.productPicture = productPicture;
        this.Categories = Categories;
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

    public Categories getCategories() {
        return this.Categories;
    }

    public void setCategories(Categories Categories) {
        this.Categories = Categories;
    }

}
