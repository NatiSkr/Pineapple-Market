package com.project.marketapi.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "user")
// Allow serialization
public class User implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private int id;

    @NotBlank
    @Column(name = "username", unique=true)
    private String username;

    @NotBlank
    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name_p")
    private String lastNameP;

    @Column(name = "last_name_m")
    private String lastNameM;

    @Column(name = "creation_date")
    @Temporal(TemporalType.DATE)
    Date creationDate;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(	name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
    /*
    FetchType.LAZY updates row correctly BUT throws error 500: internal server error.
    Fixed with EAGER fetching
    (not a good idea if we have too many users and roles but we assume few people will use this app)

    In order to scale the app for bigger customers this should get fixed with @Transactional at service

    Check this related question at stack overflow
    https://stackoverflow.com/questions/11746499/how-to-solve-the-failed-to-lazily-initialize-a-collection-of-role-hibernate-ex

    */

    // Empty constructor
    public User() {
    }
    

    // Short and suber basic constructor, otherwise current AuthController breaks
    // Add additional information with PUT request
    // or update relevant methods to pass information when creating user at AuthController and services
    public User(String username, String password) {
        this.username = username;
        this.password = password;
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

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Set<Role> getRoles() {
        return this.roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }


}
