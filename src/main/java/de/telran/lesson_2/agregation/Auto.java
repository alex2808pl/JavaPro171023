package de.telran.lesson_2.agregation;

public class Auto {
    private String name;

    public Auto(String name) {
        this.name = name;
    }

    public Auto() {
    }

    public void run() {
        System.out.println(name + " едет.");
    }
}
