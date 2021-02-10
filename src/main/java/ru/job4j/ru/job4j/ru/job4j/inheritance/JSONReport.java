package ru.job4j.ru.job4j.ru.job4j.inheritance;

public class JSONReport extends TextReport{
    public String generate(String name, String body){
        String ls = System.lineSeparator();
        String jsonParam1 = "\"name\" : " +  name + "\"";
        String jsonParam2 = "\"body\" : " +  body + "\"";
        return "{" + ls +
                jsonParam1 + "," + ls +
                jsonParam2 + ls +
                "}";
    }
}
