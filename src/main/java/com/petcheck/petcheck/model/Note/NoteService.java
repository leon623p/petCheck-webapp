package com.petcheck.petcheck.model.Note;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NoteService {

    private NoteRepository noterepository;

    @Autowired
    public NoteService(NoteRepository noterepository) {
        this.noterepository = noterepository;
    }

    public void saveNote(Note note) {noterepository.save(note);
    }


    public Optional<Note> findNoteById(long id) {
        return noterepository.findById(id);
    }

    public List<Note> findNotes() {
        Iterable<Note> found = noterepository.findAll();
        List<Note> noteslist = new ArrayList<>();
        for (Note note : found) {
            noteslist.add(note);

        }
        return noteslist;
    }

    public List<Note> findUsersNotes(String currentuser) {
        Iterable<Note> found = noterepository.findAll();
        List<Note> noteslist = new ArrayList<>();
        for (Note note : found) {
            noteslist.add(note);
        }

        List<Note> usersnotelist = noteslist.stream()
                .filter(w -> w.getNoteowner().equals(currentuser))
                .collect(Collectors.toList());

        return usersnotelist;

    }
}