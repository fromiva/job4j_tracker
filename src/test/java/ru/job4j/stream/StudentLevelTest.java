package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StudentLevelTest {
    @Test
    public void whenSorted() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(28, "Masha"));
        students.add(new Student(128, "Pety"));
        List<Student> expected = List.of(
                new Student(28, "Masha"),
                new Student(128, "Pety")
        );
        List<Student> actual = StudentLevel.levelOf(students, 20);
        assertEquals(expected, actual);
    }

    @Test
    public void whenOnlyNull() {
        List<Student> students = new ArrayList<>();
        students.add(null);
        List<Student> expected = List.of();
        List<Student> actual = StudentLevel.levelOf(students, 100);
        assertEquals(expected, actual);
    }

    @Test
    public void whenHasNull() {
        List<Student> students = new ArrayList<>();
        students.add(null);
        students.add(new Student(28, "Pety"));
        List<Student> expected = List.of(new Student(28, "Pety"));
        List<Student> actual = StudentLevel.levelOf(students, 10);
        assertEquals(expected, actual);
    }
}