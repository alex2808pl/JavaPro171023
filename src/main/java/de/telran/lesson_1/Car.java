package de.telran.lesson_1;

public class Car {

    static boolean isEngine = true;
    String name;
    int weight;
    String color;
    private int countPassenger; // set/getCountPassenger

    public void setCountPassenger(int countPassenger) {
        if(countPassenger>=0) {
            this.countPassenger = countPassenger;
        }
        else System.out.println("Ошибочное значение параметра");
    }

    public int getCountPassenger() {
        return countPassenger;
    }

    Car() {
//        name = null;
//        weight = 0;
//        color = null;
//        countPassenger = 0;
    }

    public Car(String name, int weight, String color) {
        this.name = name;
        this.weight = weight;
        this.color = color;
    }

    public Car(String name, int weight, String color, int countPassenger) {
        this.name = name;
        this.weight = weight;
        this.color = color;
        this.setCountPassenger(countPassenger);
    }

    public void run() {
        System.out.println("Едет авто - "+name+" весом - "+weight+" цвет - "+color);
    }

    void transport() {
        System.out.println("Авто перевозит пассажиров - "+countPassenger);
    }
}
