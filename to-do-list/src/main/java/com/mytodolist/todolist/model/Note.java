package com.mytodolist.todolist.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Note {
    @Id
    @GeneratedValue
    private long id;
    @Column
    private String description;
    @Column
    private String status;
    @Column
    private String subtask;

    public String getSubtask() {
        return subtask;
    }

    public void setSubtask(String subtask) {
        this.subtask = subtask;
    }
    //    @OneToMany
//    private List<Item> itemList;

//    public List<Item> getItemList() {
//        return itemList;
//    }
//
//    public void setItemList(List<Item> itemList) {
//        this.itemList = itemList;
//    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
