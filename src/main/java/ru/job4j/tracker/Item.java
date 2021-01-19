package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class Item {
    private int id;
    private String name;
    private LocalDateTime created =  LocalDateTime.now();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getLocalDateTime(){
        return this.created;
    }
}