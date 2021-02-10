package ru.job4j.oop;

import java.time.LocalDate;

public class Engineer extends Profession{

    public Engineer(String name, String surname, String education, LocalDate birthsday) {
        super(name, surname, education, birthsday);
    }
}
