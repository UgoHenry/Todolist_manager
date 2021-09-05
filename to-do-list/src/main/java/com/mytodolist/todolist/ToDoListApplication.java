package com.mytodolist.todolist;

import com.mytodolist.todolist.model.Note;
import com.mytodolist.todolist.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ToDoListApplication implements CommandLineRunner {
	@Autowired
	NoteService noteService;

	public static void main(String[] args) {
		SpringApplication.run(ToDoListApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<Note> note1 = new ArrayList<>();
		note1.add(noteService.addNote("Shopping", "done"));
		note1.add(noteService.addNote("Gym", "archived"));


	}
}
