package ru.job4j.tracker.oop.profession;

public class Builder extends Engineer {

    private String buildingType;

    public Builder(String name, String surname, String educations, String birthday, String branch) {
        super(name, surname, educations, birthday, branch);
    }

    public Building building(Projects projects) {
        return new Building();
    }

}
