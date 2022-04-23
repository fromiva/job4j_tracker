package ru.job4j.collection;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class DepDescCompTest {
    @Test
    public void compare() {
        int actual = new DepDescComp().compare(
                "K2/SK1/SSK2",
                "K2/SK1/SSK1"
        );
        assertTrue(actual > 0);
    }

    @Test
    public void whenUpDepartmentGoBefore() {
        int actual = new DepDescComp().compare(
                "K2",
                "K2/SK1"
        );
        assertTrue(actual < 0);
    }

    @Test
    public void whenFirstDepartmentIsDifferentThenAsc() {
        int actual = new DepDescComp().compare(
                "K2/SK1/SSK1",
                "K1/SK1/SSK2"
        );
        assertTrue(actual < 0);
    }

    @Test
    public void whenFirstDepartmentIsDifferentThenDesc() {
        int actual = new DepDescComp().compare(
                "K1/SK1/SSK1",
                "K2/SK1"
        );
        assertTrue(actual > 0);
    }
}