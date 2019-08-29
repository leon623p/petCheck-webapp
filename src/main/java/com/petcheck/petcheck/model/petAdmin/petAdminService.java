package com.petcheck.petcheck.model.petAdmin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class petAdminService {
    private petAdminRepository petadminrepository;

    @Autowired
    public petAdminService(petAdminRepository petadminrepository) {
        this.petadminrepository = petadminrepository;
    }

    public void savePetAdmin(petAdmin petadmin) {
        petadminrepository.save(petadmin);
    }
}
