package ru.job4j.stream;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ListToMapTest {
    @Test
    public void whenInputListNotHaveDuplicate() {
        List<Student> list = Arrays.asList(
                new Student(30, "Ivanov"),
                new Student(40, "Petrov"),
                new Student(50, "Sidorov")
        );
        Map<String, Student> expected = new LinkedHashMap<>();
        expected.put("Ivanov", new Student(30, "Ivanov"));
        expected.put("Petrov", new Student(40, "Petrov"));
        expected.put("Sidorov", new Student(50, "Sidorov"));
        Map<String, Student> actual = ListToMap.convert(list);
        assertEquals(expected, actual);
    }

    @Test
    public void whenInputListHaveDuplicate() {
        List<Student> list = Arrays.asList(
                new Student(30, "Ivanov"),
                new Student(40, "Petrov"),
                new Student(50, "Ivanov"),
                new Student(60, "Sidorov"),
                new Student(70, "Petrov")
        );
        Map<String, Student> expected = new LinkedHashMap<>();
        expected.put("Ivanov", new Student(30, "Ivanov"));
        expected.put("Petrov", new Student(40, "Petrov"));
        expected.put("Sidorov", new Student(60, "Sidorov"));
        Map<String, Student> actual = ListToMap.convert(list);
        assertEquals(expected, actual);
    }
}
