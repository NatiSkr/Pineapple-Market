package com.example.spring256market.models;

import java.sql.Blob;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Order Id", nullable = false, unique = true)
    private int id;

    @Column(name = "Product Name", nullable = false, unique = true)
    private String productName;

    @Column(name = "Order description (optional)", nullable = true, unique = true)
    private String productDescription;

    @Column(name = "Quantity", nullable = false, unique = false)
    private int productQuantity;

    @Column(name = "Unit Price", nullable = false, unique = false)
    private double productUnitPrice;

    @Column(name = "Preview", nullable = true, unique = false)
    private Blob product_picture;

    @Column(name = "Date", nullable = false, unique = false)
    @Temporal(TemporalType.TIMESTAMP)
    Date orderDate;

    public Order() {
    }
    // Empty constructor

    public Order(int id, String productName, String productDescription, int productQuantity, double productUnitPrice,
            Blob product_picture, Date orderDate) {
        this.id = id;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productQuantity = productQuantity;
        this.productUnitPrice = productUnitPrice;
        this.product_picture = product_picture;
        this.orderDate = orderDate;
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

    public Blob getProduct_picture() {
        return this.product_picture;
    }

    public void setProduct_picture(Blob product_picture) {
        this.product_picture = product_picture;
    }

    public Date getOrderDate() {
        return this.orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

}
