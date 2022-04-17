package ru.job4j.list;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class ConvertMatrix2ListTest {

    @Test
    public void when2on2ArrayThenList4() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] input = {
                {1, 2},
                {3, 4}
        };
        List<Integer> expected = Arrays.asList(1, 2, 3, 4);
        List<Integer> actual = list.toList(input);
        assertEquals(expected, actual);
    }

    @Test
    public void when4on4ArrayThenList14() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] input = {
                {1, 2, 3},
                {4, 5, 6, 7},
                {8, 9, 10},
                {11, 12, 13, 14}
        };
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14);
        List<Integer> actual = list.toList(input);
        assertEquals(expected, actual);
    }
}