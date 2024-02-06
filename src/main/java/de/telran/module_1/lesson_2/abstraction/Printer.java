package de.telran.module_1.lesson_2.abstraction;

public abstract class Printer {
    String name;
    String color;

    void tankstelle() {
        System.out.println(name+ " -  нужно запроавлять");
    }
    abstract void print();
}
