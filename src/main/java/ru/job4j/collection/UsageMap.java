package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("mendeleev@mail.ru", "Dmitri Mendeleev");
        map.put("lomonosov@yandex.ru", "Mikhail Lomonosov");
        map.put("volta@gmail.com", "Alessandro Volta");
        map.put("mendeleev@mail.ru", "Dmitri Mendeleev");
        for (String key : map.keySet()) {
            System.out.println(key + " = " + map.get(key));
        }
    }
}
