package ru.job4j.oop;

import java.time.LocalDate;

public class Surgeon extends Doctor {
    public Surgeon(String name, String surname, String education, LocalDate birthsday, int license) {
        super(name, surname, education, birthsday, license);
    }
}
