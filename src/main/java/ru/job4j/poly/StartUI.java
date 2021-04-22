package ru.job4j.poly;

public class StartUI {
    public static void main(String[] args) {
        Vehicle plane = new Plane();
        Vehicle train = new Train();
        Vehicle bus = new Bus();
        Vehicle[] vehicles = new Vehicle[]{plane, bus, train};

        for (Vehicle v : vehicles){
            v.move();
        }
    }
}
