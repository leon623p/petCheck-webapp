package com.petcheck.petcheck.model.Caretaker;


import com.petcheck.petcheck.model.petAdmin.petAdmin;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Caretaker {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;



    private String name;
    private String email;
    private petAdmin owner;

    public Caretaker(String name, petAdmin owner) {
        this.name = name;
        this.owner = owner;
    }

    public Caretaker() {
    }
}





