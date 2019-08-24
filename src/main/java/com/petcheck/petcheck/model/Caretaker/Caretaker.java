package com.petcheck.petcheck.model.Caretaker;


import com.petcheck.petcheck.model.petOwner.petOwner;



public class Caretaker {

    private String name;
    private String email;
    private petOwner owner;

    public Caretaker(String name, petOwner owner) {
        this.name = name;
        this.owner = owner;
    }

    public Caretaker() {
    }
}





