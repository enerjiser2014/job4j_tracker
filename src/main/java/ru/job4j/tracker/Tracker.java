package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
            }
        }
        return rsl;
    }

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        int arrSize = 0;
        Item[] byName = new Item[100];
        for (int index = 0; index < size; index++) {
            Item el = items[index];
            // el.getname==key
            if (el.getName().equals(key)) {
                byName[arrSize++] = el;
            }
        }
        return Arrays.copyOf(byName, arrSize);
    }

    public Item findById(int id) {
        int index = indexOf(id);
        if (index !=-1) {
            return items[index];
        }
        return null;
        //return index != -1 ? items[index] : null;
    }

    public boolean replace(int id, Item item){
        boolean rsl = false;
        int index = indexOf(id);
        if (index != -1) {
            items[index] = item;
            rsl = true;
        }
        return rsl;
    }
}