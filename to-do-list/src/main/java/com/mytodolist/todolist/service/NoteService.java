package com.mytodolist.todolist.service;

import com.mytodolist.todolist.model.Note;
import com.mytodolist.todolist.repository.NoteRepository;
import jdk.nashorn.internal.ir.Optimistic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {
    @Autowired
    private NoteRepository noteRepository;

//    public Note addNote(String description, String status ){
//        Note note1 = new Note();
//        note1.setStatus(status);
//        note1.setDescription(description);
//        noteRepository.save(note1);
//        return note1;
//    }

    public List<Note> listAllNotes(){

        return noteRepository.findAll();
    }

    public void saveNote(Note note){
        this.noteRepository.save(note);
    }

    public Note getNoteById(long id){
        Optional <Note> optional = noteRepository.findById(id);
        Note note = null;
        if (optional.isPresent()){
            note = optional.get();
        }else {
            throw new RuntimeException("Note not found for id :: "+ id);
        }
        return note;
    }

    public void deleteNoteById(long id){
        this.noteRepository.deleteById(id);
    }

    public List <Note> getNotesByStatus(String status){
       List <Note> notes = noteRepository.findByStatus(status);
        return notes;
    }


}
