package de.telran.lesson_2.abstraction;

public abstract class Printer {
    String name;
    String color;

    void tankstelle() {
        System.out.println(name+ " -  нужно запроавлять");
    }
    abstract void print();
}
