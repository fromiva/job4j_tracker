package ru.job4j.collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserTest {
    @Test
    public void whenAsc() {
        Set<User> users = new TreeSet<>();
        users.add(new User("Petr", 32));
        users.add(new User("Ivan", 31));
        Iterator<User> iterator = users.iterator();
        assertEquals(iterator.next(), new User("Ivan", 31));
        assertEquals(iterator.next(), new User("Petr", 32));
    }

    @Test
    public void whenAscForUsersWithEqualNameButDifferentAge() {
        Set<User> actual = new TreeSet<>(Arrays.asList(
                new User("Petr", 35),
                new User("Ivan", 31),
                new User("Petr", 25),
                new User("Ivan", 29),
                new User("Petr", 33),
                new User("Ivan", 27)
        ));
        Set<User> expected = new TreeSet<>(Arrays.asList(
                new User("Ivan", 27),
                new User("Ivan", 29),
                new User("Ivan", 31),
                new User("Petr", 25),
                new User("Petr", 33),
                new User("Petr", 35)
        ));
        assertEquals(expected, actual);
    }

    @Test
    public void whenComparePetrVSIvan() {
        User user1 = new User("Petr", 32);
        User user2 = new User("Ivan", 31);
        int actual = user1.compareTo(user2);
        assertTrue(actual > 0);
    }

    @Test
    public void whenComparePetrVSPetrWithDifferentAge() {
        User user1 = new User("Petr", 31);
        User user2 = new User("Petr", 32);
        int actual = user1.compareTo(user2);
        assertTrue(actual < 0);
    }
}