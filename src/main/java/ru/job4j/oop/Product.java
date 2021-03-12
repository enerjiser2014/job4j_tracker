package ru.job4j.oop;

public class Product {
    private String name;
    private int price;

    public Product(){

    }

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int price() {
        return price - disccount();
    }

    public int disccount(){
        return 0;
    }

    public int discount() {
        return 0;
    }

    public String label() {
        return name + " " + price();
    }
}