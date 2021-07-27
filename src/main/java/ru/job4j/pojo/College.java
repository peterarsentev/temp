package ru.job4j.pojo;

import java.time.LocalDate;

public class College {

    public static void main(String[] args) {
        Student max = new Student();
        max.setFio("Плесков М.Ю.");
        max.setNumberGroup(141);
        max.setLocalDate(LocalDate.of(1999, 9, 1));
        System.out.println("ФИО студента: " + max.getFio());
        System.out.println("Номер группы студента " + max.getFio() + ": " + max.getNumberGroup());
        System.out.println("Дата поступления студента " + max.getFio() + ": " + max.getLocalDate());
    }

}
