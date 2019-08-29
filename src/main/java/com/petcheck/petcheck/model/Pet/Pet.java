package com.petcheck.petcheck.model.Pet;


import com.petcheck.petcheck.model.petAdmin.petAdmin;

import javax.persistence.*;

@Entity
public class Pet extends petAdmin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String type;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "petAdmin_id", nullable = false)
    private petAdmin petadmin;

   // private String profilepic;

}

