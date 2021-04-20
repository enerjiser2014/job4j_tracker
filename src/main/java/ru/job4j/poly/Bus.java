package ru.job4j.poly;

public class Bus implements Transport {
    private int passangers;
    private int fuel;
    @Override
    public void drive(int passangers) {
        this.passangers = passangers;
    }

    @Override
    public int addFuel(int volume) {
        this.fuel += volume;
        return this.fuel;
    }
}
