package ru.job4j.ex;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void calcWhenNLessThanZero() {
        Fact fact = new Fact();
        int n = -3;
        fact.calc(n);
    }

    @Test
    public void calcWhenNMoreThanZero() {
        Fact fact = new Fact();
        int n = 3;
        int expected = 6;
        int actual = fact.calc(n);
        assertEquals(expected, actual);
    }
}