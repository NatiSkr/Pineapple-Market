package com.example.spring256market.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Order Id", nullable = false, unique = true)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER) // exception to lazy loading
    @Column(name = "User Id", nullable = false, unique = false)
    private int Users_id;

    public Orders() {
    }

    public Orders(int id, int Users_id) {
        this.id = id;
        this.Users_id = Users_id;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsers_id() {
        return this.Users_id;
    }

    public void setUsers_id(int Users_id) {
        this.Users_id = Users_id;
    }

}
