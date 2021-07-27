package ru.job4j.tracker.oop.profession;

public class Programmer extends Engineer {

    private String programLanguage;

    public Programmer(String name, String surname, String educations, String birthday, String branch, String programLanguage) {
        super(name, surname, educations, birthday, branch);
        this.programLanguage = programLanguage;
    }

    public void writeAProgram(Projects projects) {

    }

}
