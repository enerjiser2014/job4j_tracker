package ru.job4j.ex;

import org.junit.Test;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void calcTestSmallThen0() {
        int rsl = new Fact().calc(-1);
    }
}