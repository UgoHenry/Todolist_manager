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

    //display list of note
    @GetMapping("/")
    public String viewNotes(Model model) {
        List<Note> todo = noteService.listAllNotes();
        model.addAttribute("notes", todo);
        return "index";
    }

    @GetMapping("/showNewNoteForm")
    public String showNewNoteForm(Model model) {
        //create model attribute to bind form data
        Note note = new Note();
        model.addAttribute("note", note);
        return "new_note";
    }

//    @RequestMapping(value="/save", method= RequestMethod.POST)
//    public ModelAndView save(@ModelAttribute Note note)
//    {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("user-data");
//        modelAndView.addObject("user", note);
//        return modelAndView;
//    }

//    @PostMapping("/saveNote")
//    public String addNewNoteUsingPost(@RequestBody NoteRequest request) {
//        noteService.addNote(
//                request.getDescription(),
//                request.getStatus());
//        return "redirect:/";
//    }

    @PostMapping("/saveNote")
    public String saveNote(@ModelAttribute("note") Note note){
        // save note to DB
        noteService.saveNote(note);
        return "redirect:/";
    }

    @GetMapping("/showFormForEdit/{id}")
    public String showFormForEdit(@PathVariable(value = "id") long id, Model model){
        // get note from service
        Note note = noteService.getNoteById(id);

        // set note as a model attribute to pre-populate the form
        model.addAttribute("note", note);
        return "Edit_note";
    }

    @GetMapping("/deleteNote/{id}")
    public String deleteNote(@PathVariable(value = "id") long id){
        // call delete note method
        this.noteService.deleteNoteById(id);
        return "redirect:/";
    }


}
