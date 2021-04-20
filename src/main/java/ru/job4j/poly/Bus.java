package ru.job4j.poly;

public class Bus implements Transport {
    private int passangers;
    private int fuel;

    @Override
    public void drive() {
    }

    @Override
    public int addFuel(int volume) {
        this.fuel += volume;
        return this.fuel;
    }

    @Override
    public void setPassanger(int passangers) {
        this.passangers = passangers;
    }
}
