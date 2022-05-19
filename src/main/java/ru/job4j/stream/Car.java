package ru.job4j.stream;

import java.time.LocalDate;
import java.time.Month;

public class Car {
    private String brand;
    private String model;
    private LocalDate created;
    private double volume;
    private String colour;

    static class Builder {
        private String brand;
        private String model;
        private LocalDate created;
        private double volume;
        private String colour;

        Builder buildBrand(String brand) {
            this.brand = brand;
            return this;
        }

        Builder buildModel(String model) {
            this.model = model;
            return this;
        }

        Builder buildCreated(LocalDate created) {
            this.created = created;
            return this;
        }

        Builder buildVolume(double volume) {
            this.volume = volume;
            return this;
        }

        Builder buildColour(String colour) {
            this.colour = colour;
            return this;
        }

        Car build() {
            Car car = new Car();
            car.brand = this.brand;
            car.model = this.model;
            car.created = this.created;
            car.volume = this.volume;
            car.colour = this.colour;
            return car;
        }
    }

    @Override
    public String toString() {
        return "Car{"
                + "brand='" + brand + '\''
                + ", model='" + model + '\''
                + ", created=" + created
                + ", volume=" + volume
                + ", colour='" + colour + '\''
                + '}';
    }

    public static void main(String[] args) {
        Car car = new Builder()
                .buildBrand("Toyota")
                .buildModel("Camry")
                .buildCreated(LocalDate.of(2021, Month.JUNE, 1))
                .buildVolume(2.5)
                .buildColour("Red")
                .build();
        System.out.println(car);

        Car anotherCar = new Builder()
                .buildBrand("Lada")
                .buildModel("VAZ-2101")
                .buildCreated(LocalDate.of(1971, Month.DECEMBER, 12))
                .buildVolume(1.2)
                .build();
        System.out.println(anotherCar);
    }
}
