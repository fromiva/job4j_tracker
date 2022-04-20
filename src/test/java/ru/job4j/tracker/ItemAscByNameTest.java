package ru.job4j.tracker;

import java.util.List;
import java.util.Arrays;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ItemAscByNameTest {

    @Test
    public void compare() {
        ItemAscByName comparator = new ItemAscByName();
        Item item1 = new Item(1, "Test Item 1");
        Item item2 = new Item(2, "Test Item 2");
        Item item3 = new Item(3, "Test Item 3");
        Item item4 = new Item(4, "Test Item 4");
        List<Item> actual = Arrays.asList(item3, item1, item4, item2);
        actual.sort(comparator);
        List<Item> expected = Arrays.asList(item1, item2, item3, item4);
        assertEquals(expected, actual);
    }
}