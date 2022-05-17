package ru.job4j.stream;

import java.util.List;
import java.util.function.Predicate;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SchoolTest {
    @Test
    public void whenCollectClassA() {
        List<Student> students = List.of(
                new Student(10, "Surname1"),
                new Student(40, "Surname4"),
                new Student(50, "Surname5"),
                new Student(70, "Surname7"),
                new Student(90, "Surname9")
        );
        School school = new School();
        Predicate<Student> predicate = student -> student.getScore() >= 70;
        List<Student> expected = List.of(
                new Student(70, "Surname7"),
                new Student(90, "Surname9")
        );
        List<Student> actual = school.collect(students, predicate);
        assertEquals(expected, actual);
    }

    @Test
    public void whenCollectClassB() {
        List<Student> students = List.of(
                new Student(20, "Surname2"),
                new Student(30, "Surname3"),
                new Student(50, "Surname5"),
                new Student(60, "Surname6"),
                new Student(80, "Surname8")
        );
        School school = new School();
        Predicate<Student> predicate = student -> student.getScore() >= 50
                && student.getScore() < 70;
        List<Student> expected = List.of(
                new Student(50, "Surname5"),
                new Student(60, "Surname6")
        );
        List<Student> actual = school.collect(students, predicate);
        assertEquals(expected, actual);
    }

    @Test
    public void whenCollectClassC() {
        List<Student> students = List.of(
                new Student(10, "Surname1"),
                new Student(30, "Surname3"),
                new Student(40, "Surname4"),
                new Student(60, "Surname6"),
                new Student(90, "Surname9")
        );
        School school = new School();
        Predicate<Student> predicate = student -> student.getScore() < 50;
        List<Student> expected = List.of(
                new Student(10, "Surname1"),
                new Student(30, "Surname3"),
                new Student(40, "Surname4")
        );
        List<Student> actual = school.collect(students, predicate);
        assertEquals(expected, actual);
    }
}