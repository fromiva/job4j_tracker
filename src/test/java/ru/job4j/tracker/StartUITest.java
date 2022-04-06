package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertNull;

public class StartUITest {

    @Test
    public void whenAddNewItem() {
        Input input = new StubInput(new String[] {"0", "Item name", "1"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new AddNewItemAction(),
                new ExitAction()
        };
        new StartUI().init(input, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenEditItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Edited item"));
        String itemId = String.valueOf(item.getId());
        String editedName = "New item name";
        Input input = new StubInput(new String[] {"0", itemId, editedName, "1"});
        UserAction[] actions = {
                new EditItemAction(),
                new ExitAction()
        };
        new StartUI().init(input, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(editedName));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        String itemId = String.valueOf(item.getId());
        Input input = new StubInput(new String[] {"0", itemId, "1"});
        UserAction[] actions = {
                new DeleteItemAction(),
                new ExitAction()
        };
        new StartUI().init(input, tracker, actions);
        assertNull(tracker.findById(item.getId()));
    }
}