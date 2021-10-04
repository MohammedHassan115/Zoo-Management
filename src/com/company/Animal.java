package com.company;

public abstract class Animal {
    protected String name;
    protected String conservationStatus;
    protected String species;

    public Animal(String name, String conservationStatus, String species ){
        this.name = name;
        this.conservationStatus = conservationStatus;
        this.species = species;
    }
    public String getName(){return this.name;}
    public String getConservationStatus(){return this.conservationStatus;}
    public String getSpecies(){return this.species;}

    public void setName(String name){this.name = name;}
    public void setConservationStatus(String conservationStatus){this.conservationStatus = conservationStatus;}
    public void setSpecies(String species){this.species = species;}

    public abstract void display();
}
