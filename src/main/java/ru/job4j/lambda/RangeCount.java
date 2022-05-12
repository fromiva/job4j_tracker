package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class RangeCount {
    public static List<Double> diapason(int start, int end, Function<Double, Double> function) {
        List<Double> result = new ArrayList<>();
        for (int index = start; index < end; index++) {
            result.add(function.apply((double) index));
        }
        return result;
    }
}
