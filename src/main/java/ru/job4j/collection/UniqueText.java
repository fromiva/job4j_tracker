package ru.job4j.collection;

import java.util.HashSet;

public class UniqueText {
    public static boolean isEquals(String originalText, String duplicatedText) {
        boolean result = true;
        String[] origin = originalText.split(" ");
        String[] text = duplicatedText.split(" ");
        HashSet<String> check = new HashSet<>();
        for (String element : origin) {
            check.add(element);
        }
        for (String element : text) {
            if (!check.contains(element)) {
                result = false;
                break;
            }
        }
        return result;
    }
}
