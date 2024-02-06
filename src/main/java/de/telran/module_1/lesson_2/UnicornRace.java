package de.telran.module_1.lesson_2;

public final class UnicornRace extends Unicorn{
    int countPassenger;

    public UnicornRace() {
    }

    public UnicornRace(String name, int weight, String color, int countHorn, int countPassenger) {
        super(name, weight, color, countHorn);
        this.countPassenger = countPassenger;
    }

    public void transportsPassenger() {
        System.out.println("единорог по имени "+name + " везет "+countPassenger + " пассажиров");
    }
}
