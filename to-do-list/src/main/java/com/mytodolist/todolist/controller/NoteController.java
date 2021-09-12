package com.mytodolist.todolist.controller;


import com.mytodolist.todolist.model.Note;
import com.mytodolist.todolist.request.NoteRequest;
import com.mytodolist.todolist.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class NoteController {
    @Autowired
    NoteService noteService;

    //display list of note
    @GetMapping("/")
    public String viewNotes(Model model) {
        List<Note> todo = noteService.getNotesByStatus("Active");
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

    @PostMapping("/saveNote")
    public String saveNote(@ModelAttribute("note") Note note){
        // save note to DB
        noteService.saveNote(note);
        return "redirect:/";
    }

    @PostMapping("/updateNote/{id}")
    public String updateNote(@PathVariable(value = "id") long id, @Validated Note note, BindingResult result, Model model){
        if (result.hasErrors()) {
            note.setId(id);
            return "/updateNote/{id}";
        }
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
    public String deleteNote(@PathVariable(value = "id") long id, @RequestParam Optional<String> redirect){
        this.noteService.deleteNoteById(id);
        return "redirect:/" + (redirect.isPresent() && redirect.get().equals("archived") ? "showArchiveList" : "");
    }

    @GetMapping("/archiveNote/{id}")
    public String archiveNoteNote(@PathVariable(value = "id") long id){
        this.noteService.setNoteStatusById(id, "archived");
        return "redirect:/";
    }

    @GetMapping("/unarchiveNote/{id}")
    public String unarchiveNoteNote(@PathVariable(value = "id") long id){
        this.noteService.setNoteStatusById(id, "active");
        return "redirect:/showArchiveList";
    }

    @GetMapping("/showArchiveList")
    public String showArchiveList(Model model){
        List<Note> notes = noteService.getNotesByStatus("archived");
        model.addAttribute("notes", notes);
        return "archive";
    }


}
