package com.petcheck.petcheck.model.Trip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripService {
    public TripService(TripRepository triprepository) {
        this.triprepository = triprepository;
    }
@Autowired
    private TripRepository triprepository;



    public void saveTrip(Trip trip) {triprepository.save(trip);
    }

    }