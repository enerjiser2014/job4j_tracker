package ru.job4j.pojo;

public class Book {
    String name;
    int pageCount;

    public  Book(String name, int pageCount){
        this.name = name;
        this.pageCount = pageCount;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
