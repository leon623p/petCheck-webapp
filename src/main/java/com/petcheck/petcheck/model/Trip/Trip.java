package com.petcheck.petcheck.model.Trip;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate depature;
    private int triplength;
    private LocalDate returndate;

    public LocalDate getDepature() {
        return depature;
    }

    public void setDepature(LocalDate depature) {
        this.depature = depature;
    }

    public int getTriplength() {
        return triplength;
    }

    public void setTriplength(int triplength) {
        this.triplength = triplength;
    }

    public LocalDate getReturndate() {
        return returndate;
    }

    public void setReturndate(LocalDate returndate) {
        this.returndate = returndate;
    }


    public Trip(String depaturestr, int triplength) {
        this.depature = LocalDate.parse(depaturestr);
        this.triplength = triplength;
        this.returndate = depature.plusDays(triplength);
    }


}
