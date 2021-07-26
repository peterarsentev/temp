package ru.job4j.tracker.oop;

public class Battery {

    private int load;

    public Battery(int load) {
        this.load = load;
    }

    public void exchange(Battery another) {
        another.load = another.load + this.load;
        this.load = 0;
    }

    public static void main(String[] args) {
        Battery battery1 = new Battery(7);
        Battery battery2 = new Battery(12);
        System.out.println(battery1.load + " " + battery2.load);
        battery1.exchange(battery2);
        System.out.println(battery1.load + " " + battery2.load);
    }
}
