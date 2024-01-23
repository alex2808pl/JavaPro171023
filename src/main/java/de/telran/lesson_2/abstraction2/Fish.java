package de.telran.lesson_2.abstraction2;

public class Fish implements Flyable{

    @Override
    public void fly() {
        System.out.println("Есть рыбы, которые охотясь взлетают!!!");
    }
}
