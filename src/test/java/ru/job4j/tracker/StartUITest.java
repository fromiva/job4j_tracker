package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertNull;

public class StartUITest {

    @Test
    public void whenAddNewItem() {
        Output output = new StubOutput();
        Input input = new StubInput(new String[] {"0", "Item name", "1"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new AddNewItemAction(output),
                new ExitAction()
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenEditItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Edited item"));
        String itemId = String.valueOf(item.getId());
        String editedName = "New item name";
        Input input = new StubInput(new String[] {"0", itemId, editedName, "1"});
        UserAction[] actions = {
                new EditItemAction(output),
                new ExitAction()
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(editedName));
    }

    @Test
    public void whenDeleteItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        String itemId = String.valueOf(item.getId());
        Input input = new StubInput(new String[] {"0", itemId, "1"});
        UserAction[] actions = {
                new DeleteItemAction(output),
                new ExitAction()
        };
        new StartUI(output).init(input, tracker, actions);
        assertNull(tracker.findById(item.getId()));
    }

    @Test
    public void whenExit() {
        Output output = new StubOutput();
        Input input = new StubInput(new String[] {"0"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {new ExitAction()};
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString(), is(
                "Menu:" + System.lineSeparator()
                        + "0. Exit Program" + System.lineSeparator()
                ));
    }
}