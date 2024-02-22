package de.telran.module_2.lesson_6;

import java.util.ArrayDeque;
import java.util.Deque;

public class SimpleArrayDequeue {
    public static void main(String[] args) {
        Deque<String> deque = new ArrayDeque<>();
        // как Stack LIFO
        deque.push("Вася");
        deque.push("Петя");
        deque.push("Валя");
        deque.push("Миша");
        deque.push("Алена");
        System.out.println(deque);

        System.out.println(deque.peek()); //подсмотрим

        System.out.println(deque.pop()); //извлекаем
        System.out.println(deque);

        deque.clear();
        // как Queue FIFO
        deque.offer("Вася");
        deque.offer("Петя");
        deque.offer("Валя");
        deque.offer("Миша");
        deque.offer("Алена");
        System.out.println(deque);

        System.out.println(deque.peek()); //подсмотрим

        System.out.println(deque.poll()); //извлекаем
        System.out.println(deque);

        // LIFO
        deque.clear();
        deque.addFirst("Вася");
        deque.addFirst("Петя");
        deque.addFirst("Валя");
        deque.addFirst("Миша");
        deque.addFirst("Алена");
        System.out.println(deque);

        System.out.println(deque.removeFirst());
        System.out.println(deque);

        // FIFO
        deque.clear();
        deque.addLast("Вася");
        deque.addLast("Петя");
        deque.addLast("Валя");
        deque.addLast("Миша");
        deque.addLast("Алена");
        System.out.println(deque);

        System.out.println(deque.removeFirst());
        System.out.println(deque);



    }
}
