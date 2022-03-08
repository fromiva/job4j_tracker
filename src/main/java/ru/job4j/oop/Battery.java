package ru.job4j.oop;

public class Battery {
    private int load;

    public Battery(int load) {
        this.load = load;
    }

    public int getLoad() {
        return this.load;
    }

    public void setLoad(int load) {
        this.load = load;
    }

    public void exchange(Battery another) {
        another.setLoad(another.getLoad() + this.getLoad());
        this.setLoad(0);
    }
}
