package com.petcheck.petcheck.model.petAdmin;

import com.petcheck.petcheck.model.Caretaker.Caretaker;
import com.petcheck.petcheck.model.Pet.Pet;
import com.petcheck.petcheck.model.Trip.Trip;

import javax.persistence.*;

@Entity
public class petAdmin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany
    private Pet pet;
@OneToOne
    private Trip trip;
@OneToOne
    private Caretaker caretaker;

    public petAdmin(Long id, String name, Pet pet) {
        this.id = id;
        this.name = name;
        this.pet = pet;
    }

    public petAdmin(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public petAdmin() {
    }
}
