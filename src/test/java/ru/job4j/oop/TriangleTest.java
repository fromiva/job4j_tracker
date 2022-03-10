package ru.job4j.oop;

import org.junit.Test;
import static org.junit.Assert.*;

public class TriangleTest {

    @Test
    public void when4and4and5ThenSemiPerimeter6Dot5() {
        double ab = 4.0;
        double ac = 4.0;
        double bc = 5.0;
        Point point = new Point(0, 0);
        Triangle triangle = new Triangle(point, point, point);

        double expected = 6.5;
        double actual = triangle.semiPerimeter(ab, ac, bc);
        assertEquals(expected, actual, 0.01);
    }

    @Test
    public void when4and4and5ThenTriangleExists() {
        double ab = 4.0;
        double ac = 4.0;
        double bc = 5.0;
        Point point = new Point(0, 0);
        Triangle triangle = new Triangle(point, point, point);

        assertTrue(triangle.exist(ab, ac, bc));
    }

    @Test
    public void when4and4and15ThenTriangleNotExists() {
        double ab = 4.0;
        double ac = 4.0;
        double bc = 15.0;
        Point point = new Point(0, 0);
        Triangle triangle = new Triangle(point, point, point);

        assertFalse(triangle.exist(ab, ac, bc));
    }

    @Test
    public void when00and40and04ThenArea8() {
        Point a = new Point(0, 0);
        Point b = new Point(4, 0);
        Point c = new Point(0, 4);
        Triangle triangle = new Triangle(a, b, c);
        double expected = 8.0;
        double actual = triangle.area();
        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void when00and00and04ThenAreaMinus1() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 0);
        Point c = new Point(0, 4);
        Triangle triangle = new Triangle(a, b, c);
        double expected = -1.0;
        double actual = triangle.area();
        assertEquals(expected, actual, 0.001);
    }
}
