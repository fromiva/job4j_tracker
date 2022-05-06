package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class DelayedExecution {
    public static void main(String[] args) {
        String[] names = {"Ivan", "Petr", "Nikolay", "Leonid"};
        Comparator<String> comparator = (left, right) -> {
            int result = right.compareTo(left);
            System.out.println("Compare - " + left + " : " + right + " = " + result);
            return result;
        };
        Arrays.sort(names, comparator);

        System.out.println("\nSorting result:");
        for (String name : names) {
            System.out.println(name);
        }
    }
}
