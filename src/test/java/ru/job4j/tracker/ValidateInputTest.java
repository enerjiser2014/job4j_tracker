package ru.job4j.tracker;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;

public class ValidateInputTest {
    @Test
    public void whenInvalidInput(){
        Output out = new StubOutput();
        Input in = new StubInput(
            new String[] {"one" , "two", "three", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        System.out.printf(String.valueOf(selected));
        assertThat(selected, is(1));
    }
}