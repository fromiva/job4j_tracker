package ru.job4j.search;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PriorityQueueTest {

    @Test
    public void whenHigherPriority() {
        var queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));
        var result = queue.take();
        assertThat(result.getDesc(), is("urgent"));
    }

    @Test
    public void whenEmptyQueue() {
        var queue = new PriorityQueue();
        queue.put(new Task("urgent", 1));
        var result = queue.take();
        assertThat(result.getDesc(), is("urgent"));
    }

    @Test
    public void whenPutAtTheEnd() {
        var queue = new PriorityQueue();
        queue.put(new Task("String 1", 1));
        queue.put(new Task("String 2", 1));
        queue.put(new Task("String 3", 2));
        queue.take();
        queue.take();
        var result = queue.take();
        assertThat(result.getDesc(), is("String 3"));
    }
}