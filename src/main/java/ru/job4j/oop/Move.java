package ru.job4j.oop;

public class Move {
    public static void main(String[] args) {
        Vehicle airplane = new Airplane();
        Vehicle train = new Train();
        Vehicle bus = new Bus();
        Vehicle[] go = new Vehicle[]{airplane, train, bus};
        for (Vehicle v : go) {
            v.move();
        }
    }
}
