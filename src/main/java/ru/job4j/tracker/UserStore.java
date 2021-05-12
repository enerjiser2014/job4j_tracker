package ru.job4j.tracker;

public class UserStore {
    public static void main(String[] args) {
        Output out = new ConsoleOutput();
        User user = new User(1, "root", "root");
        out.println(user);
    }
}
