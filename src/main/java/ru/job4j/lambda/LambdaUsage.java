package ru.job4j.lambda;

import java.util.List;
import java.util.Arrays;
import java.util.Comparator;

public class LambdaUsage {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("eeeee", "a",  "ccc", "dddd", "bb");
        Comparator<String> comparator = (left, right) -> {
            int result = Integer.compare(right.length(), left.length());
            System.out.println("Compare - " + right.length() + " : " + left.length() + " = " + result);
            return result;
        };
        strings.sort(comparator);
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
