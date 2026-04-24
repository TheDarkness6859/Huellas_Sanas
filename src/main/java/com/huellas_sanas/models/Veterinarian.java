package com.huellas_sanas.models;

public class Veterinarian extends User{

    private String specialization;

    public Veterinarian (String name, String email, String password, String specialization){

        super(name, email, password, "VETERINARIAN");

        this.specialization = specialization;

    }

}
