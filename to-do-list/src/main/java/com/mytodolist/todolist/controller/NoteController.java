package com.mytodolist.todolist.controller;


import com.mytodolist.todolist.model.Note;
import com.mytodolist.todolist.request.NoteRequest;
import com.mytodolist.todolist.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class NoteController {
    @Autowired
    NoteService noteService;

    @RequestMapping("/")
    public String index() {
        return"index";
    }

//    @GetMapping("/note")
//    public void addNewNote(
//            @RequestParam String description,
//            @RequestParam String status
//    ){noteService.addNote(description,status);}

    @RequestMapping(value="/save", method= RequestMethod.POST)
    public ModelAndView save(@ModelAttribute Note note)
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user-data");
        modelAndView.addObject("user", note);
        return modelAndView;
    }

    @PostMapping("/note/save")
    public void addNewNoteUsingPost(@RequestBody NoteRequest request) {
        noteService.addNote(
                request.getDescription(),
                request.getStatus());
    }


    @GetMapping("/note/todo")
    public String viewNotes(Model model) {
        List<Note> todo = noteService.listAllNotes();
        model.addAttribute("notes", todo);
        return "index";
    }



}
