package de.telran.lesson_4.generics;

public class Printer {
    public <T> void print(T[] items) {
        for (T item : items) {
            System.out.println(item);
        }
    }
    public void print() {
        System.out.println("Я класс -> "+this.getClass().getName());
    }
}
