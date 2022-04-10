package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output output = new StubOutput();
        Input input = new StubInput(new String[] {"one", "1"});
        ValidateInput validateInput = new ValidateInput(output, input);
        int selected = validateInput.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenValidInput() {
        Output output = new StubOutput();
        Input input = new StubInput(new String[] {"2"});
        ValidateInput validateInput = new ValidateInput(output, input);
        int selected = validateInput.askInt("Enter menu:");
        assertThat(selected, is(2));
    }

    @Test
    public void whenManyTimesValidInput() {
        String[] askString = new String[] {"1", "4", "7", "2", "2"};
        int[] expectedSelection = new int[] {1, 4, 7, 2, 2};
        Output output = new StubOutput();
        Input input = new StubInput(askString);
        ValidateInput validateInput = new ValidateInput(output, input);
        int[] selected = new int[askString.length];
        for (int index = 0; index < selected.length; index++) {
            selected[index] = validateInput.askInt("Enter menu:");
        }
        assertThat(selected, is(expectedSelection));
    }

    @Test
    public void whenInputLessThanZero() {
        Output output = new StubOutput();
        Input input = new StubInput(new String[] {"-2"});
        ValidateInput validateInput = new ValidateInput(output, input);
        int selected1 = validateInput.askInt("Enter menu:");
        assertThat(selected1, is(-2));
    }
}