package ru.job4j.tracker;

import static java.time.format.DateTimeFormatter.ofPattern;

public class StartUI {
    public static void main(String[] args) {
        Item item = new Item();
        System.out.println(item.getCreated().format(ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss")));
        System.out.println(item);
    }
}
