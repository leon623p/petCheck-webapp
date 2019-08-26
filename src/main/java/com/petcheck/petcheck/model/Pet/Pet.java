package com.petcheck.petcheck.model.Pet;


import com.petcheck.petcheck.model.petAdmin.petAdmin;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Pet extends petAdmin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String type;
   // private String profilepic;

}

