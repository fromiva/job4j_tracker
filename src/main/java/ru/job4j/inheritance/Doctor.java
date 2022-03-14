package ru.job4j.inheritance;

public class Doctor extends Profession {
    private int medicalExperience;

    public Doctor(String name, String surname, String education, String birthday, int medicalExperience) {
        super(name, surname, education, birthday);
        this.medicalExperience = medicalExperience;
    }

    public int getMedicalExperience() {
        return this.medicalExperience;
    }

    public void patientExamination(Patient patient, Diagnosis diagnosis) {
        patient.setDiagnosis(diagnosis);
    }
}
