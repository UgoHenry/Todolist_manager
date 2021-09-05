package com.mytodolist.todolist.controller;


import com.mytodolist.todolist.model.Note;
import com.mytodolist.todolist.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NoteController {
    @Autowired
    NoteService noteService;

//    @GetMapping("/")
//    public String init(@RequestHeader("User-Agent") String ua) {
////        return new ResponseEntity<>("<h1>Welcome to the Escape Room. "+ ua +"</h1>", HttpStatus.CREATED);
//        return "index";
//    }
//
//
//    @GetMapping("/note")
//    public void addNewNote(
//            @RequestParam String description,
//            @RequestParam String status
//    ){noteService.addNote(description,status);}

    @RequestMapping("/")
    public String index()
    {
        return"index";
    }
    @RequestMapping(value="/save", method= RequestMethod.POST)
    public ModelAndView save(@ModelAttribute Note note)
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user-data");
        modelAndView.addObject("user", note);
        return modelAndView;
    }



}
