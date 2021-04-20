package ru.job4j.oop;

public class HierarchyUsage {
    public static void main(String[] args) {
        Car car = new Car();
        Object obj = car;
        Object bicycle = new Bicycle();
        System.out.println(bicycle);
        System.out.println(obj instanceof Bicycle);
        //Car cb = (Car) bicycle; // код завершится с ошибок приведения типов ClassCastException
    }
}
