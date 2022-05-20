package ru.job4j.map;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CollegeTest {
    @Test
    public void whenAccountIsOptionalEmpty() {
        Map<Student, Set<Subject>> students = Map.of(
                new Student("Student1", "000001", "201-18-15"),
                Set.of(
                        new Subject("Math", 70),
                        new Subject("English", 85)
                ),
                new Student("Student2", "000002", "201-18-15"),
                Set.of(
                        new Subject("Economic", 75),
                        new Subject("Sociology", 65)
                )
        );
        College college = new College(students);
        Optional<Student> expected = Optional.empty();
        Optional<Student> actual = college.findByAccount("000010");
        assertEquals(expected, actual);
    }

    @Test
    public void whenAccountIsOptionalNotEmpty() {
        Map<Student, Set<Subject>> students = Map.of(
                new Student("Student1", "000001", "201-18-15"),
                Set.of(
                        new Subject("Math", 70),
                        new Subject("English", 85)
                ),
                new Student("Student2", "000002", "201-18-15"),
                Set.of(
                        new Subject("Economic", 75),
                        new Subject("Sociology", 65)
                )
        );
        College college = new College(students);
        String expected = "201-18-15";
        String actual = college.findByAccount("000001").get().getGroup();
        assertEquals(expected, actual);
    }

    @Test
    public void whenSubjectIsOptionalEmptyWithNotFoundAccount() {
        Map<Student, Set<Subject>> students = Map.of(
                new Student("Student1", "000001", "201-18-15"),
                Set.of(
                        new Subject("Math", 70),
                        new Subject("English", 85)
                ),
                new Student("Student2", "000002", "201-18-15"),
                Set.of(
                        new Subject("Economic", 75),
                        new Subject("Sociology", 65)
                )
        );
        College college = new College(students);
        Optional<Subject> expected = Optional.empty();
        Optional<Subject> actual = college.findBySubjectName("000010", "Sociology");
        assertEquals(expected, actual);
    }

    @Test
    public void whenSubjectIsOptionalEmptyWithFoundAccount() {
        Map<Student, Set<Subject>> students = Map.of(
                new Student("Student1", "000001", "201-18-15"),
                Set.of(
                        new Subject("Math", 70),
                        new Subject("English", 85)
                ),
                new Student("Student2", "000002", "201-18-15"),
                Set.of(
                        new Subject("Economic", 75),
                        new Subject("Sociology", 65)
                )
        );
        College college = new College(students);
        Optional<Subject> expected = Optional.empty();
        Optional<Subject> actual = college.findBySubjectName("000001", "Sociology");
        assertEquals(expected, actual);
    }

    @Test
    public void whenSubjectIsOptionalNotEmpty() {
        Map<Student, Set<Subject>> students = Map.of(
                new Student("Student1", "000001", "201-18-15"),
                Set.of(
                        new Subject("Math", 70),
                        new Subject("English", 85)
                ),
                new Student("Student2", "000002", "201-18-15"),
                Set.of(
                        new Subject("Economic", 75),
                        new Subject("Sociology", 65)
                )
        );
        College college = new College(students);
        int expected = 65;
        int actual = college.findBySubjectName("000002", "Sociology").get().getScore();
        assertEquals(expected, actual);
    }
}