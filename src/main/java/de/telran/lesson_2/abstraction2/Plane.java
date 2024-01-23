package de.telran.lesson_2.abstraction2;

public class Plane implements Flyable, Soundable{
    String model;
    int countPassenger;

    void refuel() {//заправляться
        System.out.println("Самолет заправлен.");
    }

    @Override
    public void fly() {
        System.out.println("Самолет летит используя сопротевление воздуха и крылья."+isWings);
    }

    @Override
    public void makeSound() {
        System.out.println("Двигатель самолета ревет");
    }
}
