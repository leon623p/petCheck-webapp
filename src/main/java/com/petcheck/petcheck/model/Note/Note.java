package com.petcheck.petcheck.model.Note;

import com.petcheck.petcheck.model.petAdmin.petAdmin;

import javax.persistence.*;

@Entity
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String body;
    private String tag;

    public Note() {
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "petAdmin_id", nullable = false)
    private petAdmin petadmin;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public petAdmin getPetadmin() {
        return petadmin;
    }

    public void setPetadmin(petAdmin petadmin) {
        this.petadmin = petadmin;
    }
}