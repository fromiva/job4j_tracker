package ru.job4j.poly;

public class Bus implements Transport {

    private int passengers;
    private int fuel;

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
        System.out.println(getClass().getSimpleName() + " is traveling on road.");
    }
}
