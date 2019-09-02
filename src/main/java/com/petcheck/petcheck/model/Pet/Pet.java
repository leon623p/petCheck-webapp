package com.petcheck.petcheck.model.Pet;



import javax.persistence.*;

@Entity
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String type;
    private String birthday;


   // private String profilepic;

}

