package com.example.Domains;

public class DomainModel {

    private String username;
    private String email;

    public DomainModel(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public DomainModel() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
