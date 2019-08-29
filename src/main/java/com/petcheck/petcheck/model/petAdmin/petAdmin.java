package com.petcheck.petcheck.model.petAdmin;

import com.petcheck.petcheck.model.Caretaker.Caretaker;
//import com.petcheck.petcheck.model.Note.Note;
import com.petcheck.petcheck.model.Note.Note;
import com.petcheck.petcheck.model.Pet.Pet;
import com.petcheck.petcheck.model.Trip.Trip;

import javax.persistence.*;
import java.util.Set;

@Entity
public class petAdmin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "petadmin")
    private Set<Pet> pet ;
    @OneToOne(mappedBy = "petadmin")
    private Trip trip;
    @OneToOne(mappedBy = "petadmin")
    private Caretaker caretaker;
    @OneToMany(mappedBy = "petadmin")
    private Set<Note> note;



    public petAdmin(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public petAdmin() {
    }
}
