package de.telran.module_2.lesson_6;

import javax.swing.text.html.HTMLDocument;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class SimplePriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();
        priorityQueue.add("Вася");
        priorityQueue.add("Петя");
        priorityQueue.add("Валя");
        priorityQueue.add("Миша");
        priorityQueue.add("Алена");
        System.out.println(priorityQueue);

        System.out.println(priorityQueue.element());
        while(!priorityQueue.isEmpty()) {
            System.out.print(priorityQueue.remove()+",");
        }
        System.out.println();

        priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        priorityQueue.offer("Вася");
        priorityQueue.offer("Петя");
        priorityQueue.offer("Валя");
        priorityQueue.offer("Миша");
        priorityQueue.offer("Алена");
        System.out.println(priorityQueue);

//        while(!priorityQueue.isEmpty()) {
//            System.out.print(priorityQueue.poll()+",");
//        }
//        System.out.println();

        System.out.println("замена приоритета");
        // замена приоритета
        PriorityQueue<String> priorityQueue2 = new PriorityQueue<>(Comparator.naturalOrder());
        priorityQueue2.addAll(priorityQueue);
        System.out.println(priorityQueue2);

        Iterator<String> iterator = priorityQueue2.iterator();
        while(iterator.hasNext()) {
            System.out.print(iterator.next()+",");
        }
        System.out.println();

        while(!priorityQueue2.isEmpty()) {
            String tmp = priorityQueue2.poll();
            System.out.print(tmp +",");
            if(tmp.equals("Валя")) {
                System.out.println();
                System.out.println("Следующий, будет-> "+priorityQueue2.peek());
            }
        }






    }
}
