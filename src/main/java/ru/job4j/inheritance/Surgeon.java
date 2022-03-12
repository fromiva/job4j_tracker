package ru.job4j.inheritance;

public class Surgeon extends Doctor {
    private String surgeonSpeciality;

    public Surgeon(String name, String surname, String education, String birthday, int medicalExperience, String surgeonSpeciality) {
        super(name, surname, education, birthday, medicalExperience);
        this.surgeonSpeciality = surgeonSpeciality;
    }

    public String getSurgeonSpeciality() {
        return this.surgeonSpeciality;
    }
}
