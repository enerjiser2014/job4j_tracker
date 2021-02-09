package ru.job4j.oop;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Profession {
    private String name;
    private String surname;
    private String education;
    private LocalDate birthsday;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEducation() {
        return education;
    }

    public LocalDate getBirthsday() {
        return birthsday;
    }
}
