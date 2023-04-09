package com.ertugrulBackend.noteKeeper.service;

import com.ertugrulBackend.noteKeeper.model.Note;
import com.ertugrulBackend.noteKeeper.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }
}
