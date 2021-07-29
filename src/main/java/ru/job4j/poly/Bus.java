package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void drive() {
        System.out.println("Автобус поехал.");
    }

    @Override
    public void passengers(int pass) {
        System.out.println("В автобусе " + pass + " пассажиров.");
    }

    @Override
    public double priceRefuel(int fuel) {
        return fuel * 49.84;
    }
}
