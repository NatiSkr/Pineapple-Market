package com.example.spring256market.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "User Id", nullable = false, unique = true)
    private int id;

    @Column(name = "Role", nullable = false)
    private boolean isAdmin;
    // is_admin=true for administrator user, false for regular users

    @Column(name = "Username", nullable = false, unique = true)
    private String userName;

    @Column(name = "Email", nullable = false, unique = true)
    private String email;

    @Column(name = "Password", nullable = false)
    private String password;

    @Column(name = "First name", nullable = false)
    private String firstName;

    @Column(name = "Paternal last name", nullable = false)
    private String lastNameP;

    @Column(name = "Maternal last name", nullable = true)
    private String lastNameM;

    @Temporal(TemporalType.TIMESTAMP)
    Date creationDate;

    public Users() {
    }
    // Empty constructor

    public Users(int id, boolean isAdmin, String userName, String email, String password, String firstName,
            String lastNameP, String lastNameM, Date creationDate) {
        this.id = id;
        this.isAdmin = isAdmin;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastNameP = lastNameP;
        this.lastNameM = lastNameM;
        this.creationDate = creationDate;
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

    public boolean isIsAdmin() {
        return this.isAdmin;
    }

    public boolean getIsAdmin() {
        return this.isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastNameP() {
        return this.lastNameP;
    }

    public void setLastNameP(String lastNameP) {
        this.lastNameP = lastNameP;
    }

    public String getLastNameM() {
        return this.lastNameM;
    }

    public void setLastNameM(String lastNameM) {
        this.lastNameM = lastNameM;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

}
