package de.telran.lesson_2.polymorphism.dynamic.interfaces;

public class Dog implements DancerInterface{
    @Override
    public void dance() {
        System.out.println("Собачка танцует на задних лапках");
    }
}
