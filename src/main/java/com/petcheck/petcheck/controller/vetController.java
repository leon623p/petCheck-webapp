package com.petcheck.petcheck.controller;


import com.petcheck.petcheck.model.Vet.Vet;
import com.petcheck.petcheck.model.Vet.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@Controller
public class vetController {
    private VetService vetservice;

    @Autowired
    public vetController(VetService vetservice) {
        this.vetservice = vetservice;
    }

    @GetMapping("/vet")
    public String task(@RequestParam(required = false, name = "id") Long id, Model model) {
        Vet vet;
        if (id == null) {
            vet = new Vet();

        } else {
            vet = vetservice.findVetById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Could not find Vet" + id));
        }
        model.addAttribute("vet", vet);


        return "vet";
    }

    @PostMapping("/vet")
    public String saveVet(@ModelAttribute Vet vet, Model model) {
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        vet.setVetowner(user);
        vet.setLog(vet.getLog().concat("||"+ vet.getLastvistreason().concat(" on: " + vet.getLastvistdate())));
        vetservice.saveVet(vet);

        model.addAttribute("vets", vetservice.findUsersVets(user));


        return "vets";
    }


    @GetMapping("/vets")
    public String userpetslist(Model model) {
        String currentuser = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("vets", vetservice.findUsersVets(currentuser));
        return "vets";
    }

    @DeleteMapping("/vet")
    public String deleteVet(@RequestParam(name = "id") Long id, Model model) {
        vetservice.deleteVet(id);
        model.addAttribute("deleted", id);
        return "redirect:/vets";
    }
}
