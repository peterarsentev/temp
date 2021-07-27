package ru.job4j.tracker.oop.profession;

public class Doctor extends Profession {

    private String namesHospital;

    public Doctor(String name, String surname, String educations, String birthday, String namesHospital) {
        super(name, surname, educations, birthday);
        this.namesHospital = namesHospital;
    }

    public Diagnos heal(Pacients pacient) {
        return new Diagnos();
    }
}
