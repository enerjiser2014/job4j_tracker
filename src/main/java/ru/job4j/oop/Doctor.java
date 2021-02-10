package ru.job4j.oop;

import java.time.LocalDate;

public class Doctor extends Profession{
    private int license;

    public Doctor(String name, String surname, String education, LocalDate birthsday, int license) {
        super(name, surname, education, birthsday);
        this.license = license;
    }
}
