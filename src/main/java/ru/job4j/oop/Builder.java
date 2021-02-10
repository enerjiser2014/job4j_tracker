package ru.job4j.oop;

import java.time.LocalDate;

public class Builder extends Engineer {
    public Builder(String name, String surname, String education, LocalDate birthsday) {
        super(name, surname, education, birthsday);
    }
}
