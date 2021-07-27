package ru.job4j.tracker.oop.profession;

public class Engineer extends Profession {

    private String branch;

    public Engineer(String name, String surname, String educations, String birthday, String branch) {
        super(name, surname, educations, birthday);
        this.branch = branch;
    }

    public Projects project(Tasks tas) {
        return new Projects();
    }

}
