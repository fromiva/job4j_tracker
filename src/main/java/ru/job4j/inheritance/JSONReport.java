package ru.job4j.inheritance;

public class JSONReport {
    public String generate(String name, String body) {
        String lsep = System.lineSeparator();
        return "{" + lsep
                + "\t\"name\" : \"" + name + "\"," + lsep
                + "\t\"body\" : \"" + body + "\"" + lsep
                + "}";
    }
}
