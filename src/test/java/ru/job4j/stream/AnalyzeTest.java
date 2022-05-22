package ru.job4j.stream;

import java.util.List;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AnalyzeTest {
    @Test
    public void whenSinglePupil() {
        List<Pupil> pupils = List.of(
                new Pupil("Ivanov", List.of(
                        new Subject("Math", 100)
                ))
        );
        double expected = 100D;
        double actual = Analyze.averageScore(pupils.stream());
        assertEquals(expected, actual, 0.1);
    }

    @Test
    public void whenPupilAverage() {
        List<Pupil> pupils = List.of(
                new Pupil("Ivanov", List.of(
                        new Subject("Math", 100)
                )),
                new Pupil("Petrov", List.of(
                        new Subject("Math", 60)
                ))
        );
        double expected = 80D;
        double actual = Analyze.averageScore(pupils.stream());
        assertEquals(expected, actual, 0.1);
    }

    @Test
    public void whenListOfPupilAverage() {
        List<Pupil> pupils = List.of(
                new Pupil("Ivanov", List.of(
                        new Subject("Math", 100),
                        new Subject("Lang", 90)
                )),
                new Pupil("Petrov", List.of(
                        new Subject("Math", 60),
                        new Subject("Lang", 80)
                ))
        );
        List<Tuple> expected = List.of(
                new Tuple("Ivanov", 95D),
                new Tuple("Petrov", 70D)
        );
        List<Tuple> actual = Analyze.averageScoreBySubject(pupils.stream());
        assertEquals(expected, actual);
    }

    @Test
    public void whenListOfSubjectAverage() {
        List<Pupil> pupils = List.of(
                new Pupil("Ivanov", List.of(
                        new Subject("Math", 100),
                        new Subject("Lang", 100),
                        new Subject("Philosophy", 100),
                        new Subject("History", 100)
                )),
                new Pupil("Petrov", List.of(
                        new Subject("Math", 60),
                        new Subject("Lang", 60),
                        new Subject("Philosophy", 60)
                ))
        );
        List<Tuple> expected = List.of(
                new Tuple("Math", 80D),
                new Tuple("Lang", 80D),
                new Tuple("Philosophy", 80D),
                new Tuple("History", 100D)
        );
        List<Tuple> actual = Analyze.averageScoreByPupil(pupils.stream());
        assertEquals(expected, actual);
    }

    @Test
    public void whenBestPupil() {
        List<Pupil> pupils = List.of(
                new Pupil("Ivanov", List.of(
                        new Subject("Math", 100),
                        new Subject("Lang", 100)
                )),
                new Pupil("Petrov", List.of(
                        new Subject("Math", 60),
                        new Subject("Lang", 60)
                ))
        );
        Tuple expected = new Tuple("Ivanov", 200D);
        Tuple actual = Analyze.bestStudent(pupils.stream());
        assertEquals(expected, actual);
    }

    @Test
    public void whenBestSubject() {
        List<Pupil> pupils = List.of(
                new Pupil("Ivanov", List.of(
                        new Subject("Math", 100),
                        new Subject("Lang", 40)
                )),
                new Pupil("Petrov", List.of(
                        new Subject("Math", 60),
                        new Subject("Lang", 60)
                ))
        );
        Tuple expected = new Tuple("Math", 160D);
        Tuple actual = Analyze.bestSubject(pupils.stream());
        assertEquals(expected, actual);
    }
}
