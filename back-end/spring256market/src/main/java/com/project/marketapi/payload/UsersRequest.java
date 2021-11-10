package com.project.marketapi.payload;

import lombok.Data;

@Data
public class UsersRequest {
    // Atributes
    private boolean isAdmin;
    private String email;
    private String passWord;
    private String firstName;
    private String lastNameP;
    private String lastNameM;

    // Constructor , Getters and Setters

    public UsersRequest(boolean isAdmin, String email, String passWord, String firstName, String lastNameP, String lastNameM) {
        this.isAdmin = isAdmin;
        this.email = email;
        this.passWord = passWord;
        this.firstName = firstName;
        this.lastNameP = lastNameP;
        this.lastNameM = lastNameM;
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

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassWord() {
        return this.passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
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
