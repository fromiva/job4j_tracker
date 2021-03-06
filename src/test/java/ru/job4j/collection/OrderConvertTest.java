package ru.job4j.collection;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class OrderConvertTest {

    @Test
    public void whenSingleOrder() {
        List<Order> orders = new ArrayList<>();
        Order expected = new Order("3sfe", "Dress");
        orders.add(expected);
        HashMap<String, Order> map = OrderConvert.process(orders);
        Order actual = map.get("3sfe");
        assertEquals(expected, actual);
    }

    @Test
    public void whenDuplicatedOrder() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("8sff", "Mobile Phone"));
        orders.add(new Order("3sfe", "Shoes"));
        orders.add(new Order("3sfe", "Dress"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        int expectedSize = 2;
        int actualSize = map.size();
        assertEquals(expectedSize, actualSize);
    }
}