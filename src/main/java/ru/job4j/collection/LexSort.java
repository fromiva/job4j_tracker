package ru.job4j.collection;

import java.util.Comparator;
import static java.lang.Integer.parseInt;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String separator = ". ";
        return Integer.compare(parseInt(left.split(separator)[0]), parseInt(right.split(separator)[0]));
    }
}
