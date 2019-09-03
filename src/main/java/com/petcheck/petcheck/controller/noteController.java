package com.petcheck.petcheck.controller;

import com.petcheck.petcheck.model.Note.Note;
import com.petcheck.petcheck.model.Note.NoteService;
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
public class noteController {
    private NoteService noteservice;

    @Autowired
    public noteController(NoteService noteservice) {
        this.noteservice = noteservice;
    }

    @GetMapping("/note")
    public String task(@RequestParam(required = false, name = "id") Long id, Model model) {
        Note note;
        if (id == null) {
            note = new Note();

        } else {
            note = noteservice.findNoteById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Could not find note" + id));
        }
        model.addAttribute("note", note);


        return "note";
    }

    @PostMapping("/note")
    public String saveNote(@ModelAttribute Note note, Model model) {
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        note.setNoteowner(user);
        noteservice.saveNote(note);
        model.addAttribute("notes", noteservice.findNotes());


        return "notes";
    }
//todo do i need a non user version??
//    @GetMapping("/notes")
//    public String notesview(Model model) {
//        model.addAttribute("notes", noteservice.findNotes());
//        return "notes";
//    }

    @GetMapping("/notes")
    public String usernotelist(Model model) {
        String currentuser = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("notes", noteservice.findUsersNotes(currentuser));
        return "notes";
    }
}


