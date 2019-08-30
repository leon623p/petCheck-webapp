package com.petcheck.petcheck.model.Vet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Vet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String vetname;
    private String vetphonenumber;
    private String vetadress;
    private String buisnessname;
    private String lastvistdate;
    private String lastvistreason;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVetname() {
        return vetname;
    }

    public void setVetname(String vetname) {
        this.vetname = vetname;
    }

    public String getVetphonenumber() {
        return vetphonenumber;
    }

    public void setVetphonenumber(String vetphonenumber) {
        this.vetphonenumber = vetphonenumber;
    }

    public String getVetadress() {
        return vetadress;
    }

    public void setVetadress(String vetadress) {
        this.vetadress = vetadress;
    }

    public String getBuisnessname() {
        return buisnessname;
    }

    public void setBuisnessname(String buisnessname) {
        this.buisnessname = buisnessname;
    }

    public Vet() {
    }
}
