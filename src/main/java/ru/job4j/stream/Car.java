package ru.job4j.stream;

public class Car {

    private String model;
    private String type;
    private Boolean allRoad;
    private double volumeEngine;
    private String equipment;
    private int price;

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", type='" + type + '\'' +
                ", allRoad=" + allRoad +
                ", volumeEngine=" + volumeEngine +
                ", equipment='" + equipment + '\'' +
                ", price=" + price +
                '}';
    }

    static class Builder {
        private String model;
        private String type;
        private Boolean allRoad;
        private double volumeEngine;
        private String equipment;
        private int price;

        Builder buildModel(String model) {
            this.model = model;
            return this;
        }

        Builder buildType(String type) {
            this.type = type;
            return this;
        }

        Builder buildAllRoad(Boolean allRoad) {
            this.allRoad = allRoad;
            return this;
        }

        Builder buildVolumeEngine(double volumeEngine) {
            this.volumeEngine = volumeEngine;
            return this;
        }

        Builder buildEquipment(String equipment) {
            this.equipment = equipment;
            return this;
        }

        Builder buildPrice(int price) {
            this.price = price;
            return this;
        }

        Car build() {
            Car car = new Car();
            car.model = model;
            car.type = type;
            car.allRoad = allRoad;
            car.volumeEngine = volumeEngine;
            car.equipment = equipment;
            car.price = price;
            return car;
        }
    }

    public static void main(String[] args) {
        Car car = new Builder().buildModel("land cruiser 300")
                .buildType("SUV")
                .buildAllRoad(true)
                .buildVolumeEngine(5.7)
                .buildEquipment("Lux")
                .buildPrice(7_500_000)
                .build();
        System.out.println(car);
    }
}
