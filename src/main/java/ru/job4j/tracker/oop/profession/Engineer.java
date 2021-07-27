package ru.job4j.tracker.oop.profession;

public class Engineer extends Profession {

    public Project project(Task task) {
        return new Project();
    }

}
