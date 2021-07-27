package ru.job4j.tracker.oop.profession;

public class Dentist extends Doctor {

    private String specialization;

    public Dentist(String name, String surname, String educations, String birthday, String namesHospital, String specialization) {
        super(name, surname, educations, birthday, namesHospital);
        this.specialization = specialization;
    }

    public void treatTooth(Pacients pacient) {

    }

    public void pullOutTooth(Pacients pacient) {

    }

}
