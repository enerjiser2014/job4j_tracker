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
                break;
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
        /* Находим индекс */
        int index = indexOf(id);
        /* Если индекс найден возвращаем item, иначе null */
        return index != -1 ? items[index] : null;
    }

    public boolean replace(int id, Item item){
        boolean rsl = false;
        int index = indexOf(id);
        if (index != -1) {
            item.setId(id);
            items[index] = item;
            rsl = true;
        }
        return rsl;
    }

    public boolean delete(int id){
        int pos = indexOf(id);
        if (pos != -1) {
            System.arraycopy(items, pos + 1, items, pos, size - pos);
            items[--size] = null;
            return true;
        }
        return false;
    }
}