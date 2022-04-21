package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = Integer.compare(left.length(), right.length());
        int minLength = Math.min(left.length(), right.length());
        for (int index = 0; index < minLength; index++) {
            int temp = Character.compare(left.charAt(index), right.charAt(index));
            if (temp != 0) {
                result = temp;
                break;
            }
        }
        return result;
    }
}
