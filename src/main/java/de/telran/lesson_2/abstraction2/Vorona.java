package de.telran.lesson_2.abstraction2;

public class Vorona extends Bird{

    private String color;

    public Vorona(String name, int age, String color) {
        super(name, age);
        this.color = color;
    }

    public Vorona(String color) {
        this.color = color;
    }

    @Override
    public void fly() {
        System.out.println("Ворона летает");
    }

    @Override
    public void makeSound() {
        System.out.println("Каарр!");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
