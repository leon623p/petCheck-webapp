package com.petcheck.petcheck.model.petAdmin;

import com.petcheck.petcheck.model.Caretaker.Caretaker;
import com.petcheck.petcheck.model.Pet.Pet;
import com.petcheck.petcheck.model.Trip.Trip;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class petAdmin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Pet pet;
    private String email;
    private Trip trip;
    private Caretaker caretaker;
}
