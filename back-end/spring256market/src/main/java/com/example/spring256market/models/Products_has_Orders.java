package com.example.spring256market.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Product_has_Orders")
public class Products_has_Orders {
    @ManyToOne(fetch = FetchType.EAGER) // exception to lazy loading
    @Column(name = "Product Id", nullable = false, unique = false)
    private int Products_id;

    @ManyToOne(fetch = FetchType.EAGER) // exception to lazy loading
    @Column(name = "Order Id", nullable = false, unique = false)
    private int Orders_id;

    public Products_has_Orders() {
    }

    public Products_has_Orders(int Products_id, int Orders_id) {
        this.Products_id = Products_id;
        this.Orders_id = Orders_id;
    }

    public int getProducts_id() {
        return this.Products_id;
    }

    public void setProducts_id(int Products_id) {
        this.Products_id = Products_id;
    }

    public int getOrders_id() {
        return this.Orders_id;
    }

    public void setOrders_id(int Orders_id) {
        this.Orders_id = Orders_id;
    }

}
