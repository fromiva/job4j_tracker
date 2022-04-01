package ru.job4j.poly;

public class Bus implements Transport {

    int passengers;
    int fuel;

    public Bus() {
        this.passengers = 0;
        this.fuel = 0;
    }

    @Override
    public void setPassengers(int number) {
        this.passengers = number;
    }

    @Override
    public int refuel(int volume) {
        this.fuel += volume;
        return 0;
    }

    @Override
    public void drive() {

    }
}
