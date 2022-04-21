package ru.job4j.collection;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StringCompareTest {
    @Test
    public void whenStringsAreEqualThenZero() {
        StringCompare comparator = new StringCompare();
        int actual = comparator.compare("Ivanov", "Ivanov");
        assertEquals(0, actual);
    }

    @Test
    public void whenLeftLessThanRightResultShouldBeNegative() {
        StringCompare comparator = new StringCompare();
        int actual = comparator.compare("Ivanov", "Ivanova");
        assertTrue(actual < 0);
    }

    @Test
    public void whenLeftGreaterThanRightResultShouldBePositive() {
        StringCompare comparator = new StringCompare();
        int actual = comparator.compare("Petrov", "Ivanova");
        assertTrue(actual > 0);
    }

    @Test
    public void secondCharOfLeftGreaterThanRightShouldBePositive() {
        StringCompare comparator = new StringCompare();
        int actual = comparator.compare("Petrov", "Patrov");
        assertTrue(actual > 0);
    }

    @Test
    public void secondCharOfLeftLessThanRightShouldBeNegative() {
        StringCompare comparator = new StringCompare();
        int actual = comparator.compare("Patrova", "Petrov");
        assertTrue(actual < 0);
    }

    @Test
    public void lastCharOfLeftLessThanRightShouldBeNegative() {
        StringCompare comparator = new StringCompare();
        int actual = comparator.compare("000001", "000002");
        assertTrue(actual < 0);
    }

    @Test
    public void lastCharOfLeftMoreThanRightShouldBePositive() {
        StringCompare comparator = new StringCompare();
        int actual = comparator.compare("00000b", "00000a");
        assertTrue(actual > 0);
    }

    @Test
    public void whenLeftStringIsEmptyShouldBeNegative() {
        StringCompare comparator = new StringCompare();
        int actual = comparator.compare("", "Text");
        assertTrue(actual < 0);
    }

    @Test
    public void whenRightStringIsEmptyShouldBePositive() {
        StringCompare comparator = new StringCompare();
        int actual = comparator.compare("Text", "");
        assertTrue(actual > 0);
    }

    @Test
    public void whenBothStringIsEmptyShouldBeEquals() {
        StringCompare comparator = new StringCompare();
        int actual = comparator.compare("", "");
        assertEquals(0, actual);
    }
}