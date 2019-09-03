package com.petcheck.petcheck.model.Vet;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VetService {
    private VetRepository vetrepository;

    @Autowired
    public VetService(VetRepository vetrepository) {
        this.vetrepository = vetrepository;
    }

    public void saveVet(Vet Vet) {
        vetrepository.save(Vet);
    }

    public Optional<Vet> findVetById(long id) {
        return vetrepository.findById(id);
    }

    public List<Vet> findVets() {
        Iterable<Vet> found = vetrepository.findAll();
        List<Vet> vetslist = new ArrayList<>();
        for (Vet vet : found) {
            vetslist.add(vet);

        }
        return vetslist;
    }

    public List<Vet> findUsersPets(String currentuser) {
        Iterable<Vet> found = vetrepository.findAll();
        List<Vet> vetslist = new ArrayList<>();
        for (Vet vet : found) {
            vetslist.add(vet);
        }

        List<Vet> usersvetlist = vetslist.stream()
                .filter(w -> w.getVetowner().equals(currentuser))
                .collect(Collectors.toList());

        return usersvetlist;

    }
}
