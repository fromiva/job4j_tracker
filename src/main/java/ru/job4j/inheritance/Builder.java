package ru.job4j.inheritance;

public class Builder extends Engineer {
    private String constructionBranch;

    public Builder(String name, String surname, String education, String birthday, int workExperience, String constructionBranch) {
        super(name, surname, education, birthday, workExperience);
        this.constructionBranch = constructionBranch;
    }

    public String getConstructionBranch() {
        return this.constructionBranch;
    }
}
