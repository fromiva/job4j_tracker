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
}