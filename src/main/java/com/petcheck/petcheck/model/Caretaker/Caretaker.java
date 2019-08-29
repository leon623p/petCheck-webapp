package com.petcheck.petcheck.model.Caretaker;


import com.petcheck.petcheck.model.petAdmin.petAdmin;

import javax.persistence.*;


@Entity
public class Caretaker {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "admin_id", nullable = false)
    private petAdmin petadmin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public petAdmin getPetadmin() {
        return petadmin;
    }

    public void setPetadmin(petAdmin petadmin) {
        this.petadmin = petadmin;
    }

    public Caretaker() {
    }
}





