package com.mytodolist.todolist.service;

import com.mytodolist.todolist.model.Note;
import com.mytodolist.todolist.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteService {
    @Autowired
    private NoteRepository noteRepository;

    public Note addNote(String description, String status ){
        Note note1 = new Note();
        note1.setStatus(status);
        note1.setDescription(description);
        noteRepository.save(note1);
        return note1;
    }

}
