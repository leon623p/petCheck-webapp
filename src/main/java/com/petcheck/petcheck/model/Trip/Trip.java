package com.petcheck.petcheck.model.Trip;

import java.time.LocalDate;

public class Trip {
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
