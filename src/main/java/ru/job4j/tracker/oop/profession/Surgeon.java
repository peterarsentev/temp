package ru.job4j.tracker.oop.profession;

public class Surgeon extends Doctor{

    private String childOrAdult;

    public Surgeon(String name, String surname, String educations, String birthday, String namesHospital) {
        super(name, surname, educations, birthday, namesHospital);
    }

    public void operate(Pacients pacients, Diagnos diagnos) {

    }

}
