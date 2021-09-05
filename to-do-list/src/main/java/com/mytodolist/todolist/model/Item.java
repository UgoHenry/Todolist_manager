package com.mytodolist.todolist.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Item {
    @Id
    @GeneratedValue
    private long id;
    @Column
    private String content;
    @Column
    private boolean done;


}
