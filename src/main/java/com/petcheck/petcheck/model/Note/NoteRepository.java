package com.petcheck.petcheck.model.Note;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NoteRepository extends CrudRepository<Note,Long> {
    @Query(value = "select m from Note m where m.tag like :tag")
    public List<Note> findNoteByTag(@Param("tag") String tag);
}

