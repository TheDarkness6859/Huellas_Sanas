package com.huellas_sanas.models;

public class Client extends User{

    private String address;
    private String phone;

    public Client (String name, String email, String password, String address, String phone){

        super(name, email, password, "CLIENT");

        this.address = address;
        this.phone = phone;

    }

}
