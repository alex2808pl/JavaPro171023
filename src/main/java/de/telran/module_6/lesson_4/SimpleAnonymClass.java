package de.telran.module_6.lesson_4;

import java.util.concurrent.atomic.AtomicInteger;

public class SimpleAnonymClass {
    public static void main(String[] args) {
        Job jb1 = new Job(new AtomicInteger(0)); // именованный класс

        Runnable run1 = new Runnable() { //Анонимный класс, имплементирующий интерфейс Runnable
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Я работаю с анонимного класса - "+i);
                }
            }
        };
        new Thread(run1).start();

    }
}
