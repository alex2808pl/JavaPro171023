package de.telran.module_1.lesson_2.agregation;

public class Vehicle extends Auto{ //наследование
    private int countPassenger = 0;

    public Vehicle(String name, int countPassenger) {
        super(name);
        this.countPassenger = countPassenger;
    }

    public Vehicle() {
    }

    public void setInto(int count) {
        countPassenger+=count;
    }

    public void getInto(int count) {
        countPassenger-=count;
    }

    public int getCountPassenger() {
        return countPassenger;
    }
}
