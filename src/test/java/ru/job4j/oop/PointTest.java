package ru.job4j.oop;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PointTest {

    @Test
    public void when00To20That2() {
        Point a = new Point(0, 0);
        Point b = new Point(2, 0);

        double expected = 2.0;
        double actual = a.distance(b);
        assertEquals(expected, actual, 0.01);
    }

    @Test
    public void when00To22Then2Dot83() {
        Point a = new Point(0, 0);
        Point b = new Point(2, 2);

        double expected = 2.83;
        double actual = a.distance(b);
        assertEquals(expected, actual, 0.01);
    }

    @Test
    public void when71To29Then9Dot43() {
        Point a = new Point(7, 1);
        Point b = new Point(2, 9);

        double expected = 9.43;
        double actual = a.distance(b);
        assertEquals(expected, actual, 0.01);
    }

    @Test
    public void when100100To543Then107Dot35() {
        Point a = new Point(100, 100);
        Point b = new Point(54, 3);

        double expected = 107.35;
        double actual = a.distance(b);
        assertEquals(expected, actual, 0.01);
    }
}
