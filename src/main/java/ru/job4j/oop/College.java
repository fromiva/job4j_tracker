package ru.job4j.oop;

public class College {
    public static void main(String[] args) {
        Freshman freshman = new Freshman();

        /* Повышающее приведение типов */
        Student student = freshman;
        Object object = freshman;
    }
}
