package com.ertugrulBackend.noteKeeper.service;

import com.ertugrulBackend.noteKeeper.model.Note;
import org.springframework.stereotype.Service;

import java.util.List;

public interface NoteService {

    List<Note> getAllNotes();

}
