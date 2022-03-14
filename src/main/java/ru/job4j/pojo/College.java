package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Васильев В. В.");
        student.setGroup("2A");
        student.setDateOfAdmission(new Date());

        String sep = System.lineSeparator();
        System.out.println("Студент: " + student.getFullName() + sep
                + "Группа: " + student.getGroup() + sep
                + "Дата приёма: " + student.getDateOfAdmission());
    }
}
