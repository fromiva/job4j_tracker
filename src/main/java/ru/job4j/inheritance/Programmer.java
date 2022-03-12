package ru.job4j.inheritance;

public class Programmer extends Engineer {
    private String priorLanguage;

    public Programmer(String name, String surname, String education, String birthday, int workExperience, String priorLanguage) {
        super(name, surname, education, birthday, workExperience);
        this.priorLanguage = priorLanguage;
    }

    public String getPriorLanguage() {
        return this.priorLanguage;
    }
}
