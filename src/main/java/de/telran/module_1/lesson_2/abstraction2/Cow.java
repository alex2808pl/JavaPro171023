package de.telran.module_1.lesson_2.abstraction2;

public class Cow implements Soundable{
    int weight;
    public void getMilk() {
        System.out.println("Корова дает молоко");
    }

    @Override
    public void makeSound() {
        System.out.println("Мууу");
    }
}
