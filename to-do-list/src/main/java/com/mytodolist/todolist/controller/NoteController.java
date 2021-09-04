package com.mytodolist.todolist.controller;


import com.mytodolist.todolist.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NoteController {
    @Autowired
    NoteService noteService;

    @GetMapping("/note")
    public void addNewNote(
            @RequestParam String description,
            @RequestParam String status
    ){noteService.addNote(description,status);}

}
