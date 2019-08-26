package com.petcheck.petcheck.model.Pet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetService {
    private PetRepository prerepository;
@Autowired
    public PetService(PetRepository prerepository) {
        this.prerepository = prerepository;
    }
}
