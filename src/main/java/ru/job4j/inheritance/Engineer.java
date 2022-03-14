package ru.job4j.inheritance;

public class Engineer extends Profession {
    private int workExperience;

    public Engineer(String name, String surname, String education, String birthday, int workExperience) {
        super(name, surname, education, birthday);
        this.workExperience = workExperience;
    }

    public int getWorkExperience() {
        return this.workExperience;
    }
}
