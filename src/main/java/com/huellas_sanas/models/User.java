package com.huellas_sanas.models;

import java.util.UUID;

public  abstract class User {

    private UUID id;
    private String name;
    private String email;
    private String password;
    private String role;

    public User(String name, String email, String password, String role) {

        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;

    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

}
