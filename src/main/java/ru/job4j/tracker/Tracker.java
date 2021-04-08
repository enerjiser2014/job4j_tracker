package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll(){
        Item[] all = new Item[100];
        for (int index = 0; index < size; index++) {
            Item el = items[index];
            if (el != null) {
                all[size++] = el;
            }
        }
        return Arrays.copyOf(all, size);
    }

    public Item[] findByName(String key){
        Item[] byName = new Item[100];
        for (int index = 0; index < size; index++){
            Item el = items[index];
            if (el !=null && el.getName() == key) {
                byName[size++] = el;
            }
        }
        return Arrays.copyOf(byName, size);
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }
}