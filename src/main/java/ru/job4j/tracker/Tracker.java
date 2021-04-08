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
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key){
        int arrSize = 0;
        Item[] byName = new Item[100];
        for (int index = 0; index < arrSize; index++){
            Item el = items[index];
            // el.getname==key
            if (el.getName().equals(key)) {
                byName[arrSize++] = el;
            }
        }
        return Arrays.copyOf(byName, arrSize);
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