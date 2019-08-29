package com.petcheck.petcheck.model.Caretaker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaretakerService {
    private CaretakerRepository caretakerrepository;
@Autowired
    public CaretakerService(CaretakerRepository caretakerrepository) {
        this.caretakerrepository = caretakerrepository;
    }

    public void savePet(Caretaker caretaker) { caretakerrepository.save(caretaker);
    }

}
