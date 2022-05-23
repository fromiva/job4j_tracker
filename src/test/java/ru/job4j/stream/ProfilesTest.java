package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ProfilesTest {
    @Test
    public void whenTestMethodCollect() {
        Address first = new Address("City1", "Street1", 1, 1);
        Address second = new Address("City2", "Street2", 2, 2);
        Address third = new Address("City3", "Street3", 3, 3);
        List<Profile> profiles = Arrays.asList(
                new Profile(first),
                new Profile(second),
                new Profile(third)
        );
        List<Address> expected = Arrays.asList(
                first,
                second,
                third);
        List<Address> actual = Profiles.collect(profiles);
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
        Address first = new Address("City1", "Street1", 1, 1);
        Address second = new Address("City2", "Street2", 2, 2);
        Address third = new Address("City3", "Street3", 3, 3);
        Address fourth = new Address("City1", "Street1", 1, 1);
        Address fifth = new Address("City2", "Street2", 2, 2);
        Address seventh = new Address("City3", "Street3", 3, 3);
        List<Profile> profiles = Arrays.asList(
                new Profile(second),
                new Profile(fourth),
                new Profile(fifth),
                new Profile(first),
                new Profile(seventh),
                new Profile(third)
        );
        List<Address> expected = Arrays.asList(first, second, third);
        List<Address> actual = Profiles.collectSortWithoutDuplicate(profiles);
        assertEquals(expected, actual);
    }
}