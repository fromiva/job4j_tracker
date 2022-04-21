package ru.job4j.collection;

import java.util.Arrays;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LexSortTest {
    @Test
    public void test() {
        LexSort comparator = new LexSort();
        String[] actual = {
                "10. Task.",
                "1. Task.",
                "2. Task."
        };
        String[] expected = {
                "1. Task.",
                "2. Task.",
                "10. Task."
        };
        Arrays.sort(actual, comparator);
        assertEquals(expected, actual);
    }
}