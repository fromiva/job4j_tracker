package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ConvertListTest {
    @Test
    public void whenTwoList() {
        List<int[]> input = new ArrayList<>();
        input.add(new int[] {1});
        input.add(new int[] {2, 3});
        List<Integer> expected = Arrays.asList(1, 2, 3);
        List<Integer> actual = ConvertList.convert(input);
        assertEquals(expected, actual);
    }

    @Test
    public void whenThreeList() {
        List<int[]> input = new ArrayList<>();
        input.add(new int[] {});
        input.add(new int[] {1});
        input.add(new int[] {2, 3, 4});
        List<Integer> expected = Arrays.asList(1, 2, 3, 4);
        List<Integer> actual = ConvertList.convert(input);
        assertEquals(expected, actual);
    }
}
