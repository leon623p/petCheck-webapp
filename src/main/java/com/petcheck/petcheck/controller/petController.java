package com.petcheck.petcheck.controller;


import com.petcheck.petcheck.model.Pet.Pet;
import com.petcheck.petcheck.model.Pet.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityNotFoundException;
@Controller
public class petController {

    private PetService petservice;

    @Autowired
    public petController(PetService petservice) {
        this.petservice = petservice;
    }

    @GetMapping("/pet")
    public String task(@RequestParam(required = false, name = "id") Long id, Model model) {
        Pet pet;
        if (id == null) {
            pet = new Pet();

        } else {
            pet = petservice.findPetById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Could not find note" + id));
        }
        model.addAttribute("pet", pet);


        return "pet";
    }

    @PostMapping("/pet")
    public String savePet(@ModelAttribute Pet pet, Model model) {
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        pet.setPetowner(user);
        petservice.savePet(pet);
        model.addAttribute("pets", petservice.findPets());


        return "pets";
    }


    @GetMapping("/pets")
    public String userpetslist(Model model) {
        String currentuser = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("pets", petservice.findUsersPets(currentuser));
        return "pets";
    }
}
