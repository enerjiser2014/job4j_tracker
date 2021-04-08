package ru.job4j.tracker;

import java.time.LocalDateTime;

public class StartUI {
    public static void main(String[] args) {
        Item itemObj = new Item();
        itemObj.setName("test");
        Tracker trackerObj = new Tracker();
        trackerObj.add(itemObj);
        System.out.println(trackerObj.findById(1));
    }
}
