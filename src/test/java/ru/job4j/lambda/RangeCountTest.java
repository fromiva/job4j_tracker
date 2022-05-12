package ru.job4j.lambda;

import java.util.List;
import java.util.function.Function;
import static java.lang.Math.pow;
import static java.util.Arrays.asList;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class RangeCountTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        int start = 5;
        int end = 8;
        Function<Double, Double> function = (x) -> 2 * x + 1;
        List<Double> expected = asList(11.0, 13.0, 15.0);
        List<Double> actual = RangeCount.diapason(start, end, function);
        assertEquals(expected, actual);
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        int start = 2;
        int end = 5;
        Function<Double, Double> function = (x) -> x * x + 2 * x + 1;
        List<Double> expected = asList(9.0, 16.0, 25.0);
        List<Double> actual = RangeCount.diapason(start, end, function);
        assertEquals(expected, actual);
    }

    @Test
    public void whenExponentialFunctionThenExponentialResults() {
        int start = 2;
        int end = 5;
        Function<Double, Double> function = (x) -> pow(2, x);
        List<Double> expected = asList(4.0, 8.0, 16.0);
        List<Double> actual = RangeCount.diapason(start, end, function);
        assertEquals(expected, actual);
    }
}