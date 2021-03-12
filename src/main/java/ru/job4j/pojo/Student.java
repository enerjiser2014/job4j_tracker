package ru.job4j.pojo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {
    private String family;
    private String name;
    private String FathersName;
    private String group;
    private Date startAt;

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFathersName() {
        return FathersName;
    }

    public void setFathersName(String fathersName) {
        FathersName = fathersName;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Date getStartAt() {
        return startAt;
    }

    public void setStartAt(String startAt) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        this.startAt = formatter.parse("2020-10-10");

    }
}
