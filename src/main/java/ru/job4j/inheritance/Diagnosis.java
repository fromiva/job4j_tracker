package ru.job4j.inheritance;

public class Diagnosis {
    private String diagnosisTitle;

    public Diagnosis() {
        this.diagnosisTitle = "Healthy";
    }

    public Diagnosis(String diagnosisTitle) {
        this.diagnosisTitle = diagnosisTitle;
    }

    public void printDiagnosis() {
        System.out.println(this.diagnosisTitle);
    }
}
