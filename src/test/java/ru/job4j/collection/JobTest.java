package ru.job4j.collection;

import java.util.Comparator;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class JobTest {
    @Test
    public void whenJobAscByNameComparison() {
        Job job1 = new Job("Implement a task", 1);
        Job job2 = new Job("Fix a bug", 2);
        Comparator<Job> comparator = new JobAscByName();
        int actual = comparator.compare(job1, job2);
        assertTrue(actual > 0);
    }

    @Test
    public void whenJobDescByNameComparison() {
        Job job1 = new Job("Implement a task", 1);
        Job job2 = new Job("Fix a bug", 2);
        Comparator<Job> comparator = new JobDescByName();
        int actual = comparator.compare(job1, job2);
        assertTrue(actual < 0);
    }

    @Test
    public void whenJobAscByPriorityComparison() {
        Job job1 = new Job("Implement a task", 1);
        Job job2 = new Job("Fix a bug", 2);
        Comparator<Job> comparator = new JobAscByPriority();
        int actual = comparator.compare(job1, job2);
        assertTrue(actual < 0);
    }

    @Test
    public void whenJobDescByPriorityComparison() {
        Job job1 = new Job("Implement a task", 1);
        Job job2 = new Job("Fix a bug", 2);
        Comparator<Job> comparator = new JobDescByPriority();
        int actual = comparator.compare(job1, job2);
        assertTrue(actual > 0);
    }

    @Test
    public void whenJobAscByNameAndJobAscByPriorityComparison() {
        Job job1 = new Job("Implement a task", 2);
        Job job2 = new Job("Implement a task", 1);
        Comparator<Job> comparator = new JobAscByName().thenComparing(new JobAscByPriority());
        int actual = comparator.compare(job1, job2);
        assertTrue(actual > 0);
    }

    @Test
    public void whenJobDescByNameAndJobDescByPriorityComparison() {
        Job job1 = new Job("Implement a task", 2);
        Job job2 = new Job("Implement a task", 1);
        Comparator<Job> comparator = new JobDescByName().thenComparing(new JobDescByPriority());
        int actual = comparator.compare(job1, job2);
        assertTrue(actual < 0);
    }
}
