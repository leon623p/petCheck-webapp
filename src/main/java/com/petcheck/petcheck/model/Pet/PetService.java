package com.petcheck.petcheck.model.Pet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PetService {
    private PetRepository petrepository;

    @Autowired
    public PetService(PetRepository petrepository) {
        this.petrepository = petrepository;
    }

    public void savePet(Pet pet) {
        petrepository.save(pet);
    }
    public Optional<Pet> findPetById(long id) {
        return petrepository.findById(id);
    }

    public List<Pet> findPets() {
        Iterable<Pet> found = petrepository.findAll();
        List<Pet> petslist = new ArrayList<>();
        for (Pet pet : found) {
            petslist.add(pet);

        }
        return petslist;
    }

    public List<Pet> findUsersPets(String currentuser) {
        Iterable<Pet> found = petrepository.findAll();
        List<Pet> petslist = new ArrayList<>();
        for (Pet pet : found) {
            petslist.add(pet);
        }

        List<Pet> userspetlist = petslist.stream()
                .filter(w -> w.getPetowner().equals(currentuser))
                .collect(Collectors.toList());

        return userspetlist;

    }
    public void deletePet(Long id) { petrepository.deleteById(id);
    }
}

