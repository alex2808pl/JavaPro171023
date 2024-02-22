package de.telran.module_2.lesson_6;

import java.util.LinkedList;
import java.util.Queue;

public class SimpleQueue {
    public static void main(String[] args) {

        Queue<String> queue1 = new LinkedList<>();

        //add info
        queue1.add("Вася");
        queue1.add("Петя");
        queue1.add("Валя");
        queue1.add("Миша");
        queue1.add("Алена");
        System.out.println(queue1);

        System.out.println(queue1.remove());
        System.out.println(queue1);

        // методы Queue
        queue1.offer("Гриша"); //добавляем
        System.out.println(queue1);

        System.out.println(queue1.poll()); // извлекаем
        System.out.println(queue1);

        System.out.println(queue1.peek()); // анализ ошибок через возвращаемое значение
        System.out.println(queue1);

        System.out.println(queue1.element()); // Exception
        System.out.println(queue1);

        // Вывод
        // add, remove, element - Exception
        // offer, poll, peek - анализ ошибок по возвращаемому значение из метода

    }
}
