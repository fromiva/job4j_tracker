package ru.job4j.inheritance;

public class Dentist extends Doctor {
    private String dentistrySpeciality;

    public Dentist(String name, String surname, String education, String birthday, int medicalExperience, String dentistrySpeciality) {
        super(name, surname, education, birthday, medicalExperience);
        this.dentistrySpeciality = dentistrySpeciality;
    }

    public String getDentistrySpeciality() {
        return this.dentistrySpeciality;
    }
}
