package ru.job4j.inheritance;

public class Patient {
    private int id;
    private Diagnosis diagnosis;

    public Patient(int id) {
        this.id = id;
        this.diagnosis = new Diagnosis();
    }

    public Patient(int id, Diagnosis diagnosis) {
        this.id = id;
        this.diagnosis = diagnosis;
    }

    public int getId() {
        return this.id;
    }

    public Diagnosis getDiagnosis() {
        return this.diagnosis;
    }

    public void setDiagnosis(Diagnosis diagnosis) {
        this.diagnosis = diagnosis;
    }
}
