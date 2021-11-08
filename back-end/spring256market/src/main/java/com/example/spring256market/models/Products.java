package com.example.spring256market.models;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Product Id", nullable = false, unique = true)
    private int id;

    @Column(name = "Product Name", nullable = false, unique = true)
    private String productName;

    @Column(name = "Description", nullable = false, unique = true)
    private String productDescription;

    @Column(name = "Quantity", nullable = false, unique = false)
    private int productQuantity;

    @Column(name = "Unit Price", nullable = false, unique = false)
    private double productUnitPrice;

    @Column(name = "Preview", nullable = true, unique = false)
    private Blob productPicture;

    @ManyToOne(fetch = FetchType.EAGER) // exception to lazy loading
    @Column(name = "Category Id", nullable = false, unique = false)
    private int Categories_id;

    public Products() {
    }
    // Empty constructor

    public Products(int id, String productName, String productDescription, int productQuantity, double productUnitPrice,
            Blob productPicture, int categories_id) {
        this.id = id;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productQuantity = productQuantity;
        this.productUnitPrice = productUnitPrice;
        this.productPicture = productPicture;
        this.Categories_id = categories_id;
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

    public int getCategories_id() {
        return this.Categories_id;
    }

    public void setCategories_id(int Categories_id) {
        this.Categories_id = Categories_id;
    }

}
