package com.huellas_sanas.models;

public class Pet {

    private String id;
    private String name;
    private String specie;
    private String ownerId;

    public Pet (String name, String specie, String ownerId) {

        this.name = name;
        this.specie = specie;
        this.ownerId = ownerId;

    }

    public String getName() {
        return name;
    }

    public String getSpecie() {
        return specie;
    }

    public String getOwnerId() {
        return ownerId;
    }
}
