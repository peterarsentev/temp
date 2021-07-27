package ru.job4j.tracker.oop.profession;

public class Builder extends Engineer {

    private String buildingType;

    public Building building(Project project) {
        return new Building();
    }

}
