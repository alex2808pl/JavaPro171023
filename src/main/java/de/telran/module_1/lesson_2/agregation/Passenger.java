package de.telran.module_1.lesson_2.agregation;

public class Passenger {
    String name;
    int age;

    public Passenger(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
