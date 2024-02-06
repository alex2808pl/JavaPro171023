package de.telran.module_1.lesson_2.abstraction2;

public class SimpleBird {
    public static void main(String[] args) {
        Straus st1 = new Straus("Петя", 10, 5);
        st1.fly();
        st1.makeSound();

        Vorona vor1 = new Vorona("Каркуша", 100, "черная");
        vor1.fly();
        vor1.makeSound();
    }

}
