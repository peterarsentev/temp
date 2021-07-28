package ru.job4j.tracker.oop.profession;

public class Builder extends Engineer {

    private String buildingType;

    public Builder(String name, String surname, String educations, String birthday, String branch) {
        super(name, surname, educations, birthday, branch);
    }

    public Builder(String name, String surname, String educations, String birthday, String branch, String buildingType) {
        super(name, surname, educations, birthday, branch);
        this.buildingType = buildingType;
    }

    public Building building(Projects projects) {
        return new Building();
    }

}
