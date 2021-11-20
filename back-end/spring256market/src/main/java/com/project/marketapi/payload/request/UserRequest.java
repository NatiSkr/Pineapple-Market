package com.project.marketapi.payload.request;

import lombok.Data;

@Data
public class UserRequest {
    // Atributes
    private String username;
    private String password;
    private String firstName;
    private String lastNameP;
    private String lastNameM;

    // Constructor , Getters and Setters

    public UserRequest(String username, String password, String firstName, String lastNameP, String lastNameM) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastNameP = lastNameP;
        this.lastNameM = lastNameM;
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

}
