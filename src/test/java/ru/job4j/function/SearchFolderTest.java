package ru.job4j.function;

import java.util.List;
import java.util.function.Predicate;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SearchFolderTest {
    @Test
    public void whenFilterSize() {
        List<Folder> list = List.of(
                new Folder("fix", 110),
                new Folder("bug", 75),
                new Folder("bug", 90)
        );
        Predicate<Folder> predicate = folder -> folder.getSize() > 100;
        List<Folder> expected = List.of(new Folder("fix", 110));
        List<Folder> actual = SearchFolder.filter(list, predicate);
        assertEquals(expected, actual);
    }

    @Test
    public void whenFilterName() {
        List<Folder> list = List.of(
                new Folder("fix", 110),
                new Folder("bug", 75),
                new Folder("bug", 90)
        );
        Predicate<Folder> predicate = folder -> folder.getName().contains("bug");
        List<Folder> expected = List.of(
                new Folder("bug", 75),
                new Folder("bug", 90)
        );
        List<Folder> actual = SearchFolder.filter(list, predicate);
        assertEquals(expected, actual);
    }
}