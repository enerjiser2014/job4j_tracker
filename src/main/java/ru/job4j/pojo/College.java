package ru.job4j.pojo;

import java.text.ParseException;

public class College {
    public static void main(String[] args) throws ParseException {
        Student student = new Student();
        student.setFamily("Ivanov");
        student.setName("Iva");
        student.setFathersName("Ivanovich");
        student.setGroup("Programmers2020");
        student.setStartAt("2020-10-14");

        System.out.println("FIO: " + student.getFamily() + " " + student.getName() + " " + student.getFathersName());
        System.out.println("Group: " + student.getGroup());
        System.out.println("Start at: " + student.getStartAt());
    }
}
