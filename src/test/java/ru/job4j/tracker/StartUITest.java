package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenAddNewItem() {
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.addNewItem(input, tracker);
        Item actual = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(actual.getName(), is(expected.getName()));
    }
}