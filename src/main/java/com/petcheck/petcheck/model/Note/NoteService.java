package com.petcheck.petcheck.model.Note;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteService {

    private NoteRepository guiderepository;

    @Autowired
    public NoteService(NoteRepository guiderepository) {
        this.guiderepository = guiderepository;
    }
}