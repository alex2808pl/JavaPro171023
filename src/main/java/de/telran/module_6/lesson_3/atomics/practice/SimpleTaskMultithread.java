package de.telran.module_6.lesson_3.atomics.practice;

import java.util.concurrent.atomic.AtomicInteger;

public class SimpleTaskMultithread {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(" - Start - ");
        AtomicInteger counter = new AtomicInteger(0);
        long startTime = System.currentTimeMillis();

        ThreadTaskAtomic task1 = new ThreadTaskAtomic(2, 200000, counter);
        ThreadTaskAtomic task2 = new ThreadTaskAtomic(200001, 400000, counter);
        ThreadTaskAtomic task3 = new ThreadTaskAtomic(400001, 600000, counter);
        ThreadTaskAtomic task4 = new ThreadTaskAtomic(600001, 800000, counter);
        ThreadTaskAtomic task5 = new ThreadTaskAtomic(800_001, 1_000_000, counter);

        task5.start();
        task4.start();
        task3.start();
        task2.start();
        task1.start();


        task1.join();
        task2.join();
        task3.join();
        task4.join();
        task5.join();

        System.out.println(" Всего найдено -> "+counter.get());

//        ThreadTask task1 = new ThreadTask(2, 200000);
//        ThreadTask task2 = new ThreadTask(200001, 400000);
//        ThreadTask task3 = new ThreadTask(400001, 600000);
//        ThreadTask task4 = new ThreadTask(600001, 800000);
//        ThreadTask task5 = new ThreadTask(800_001, 1_000_000);

//
//        task5.start();
//        task4.start();
//        task3.start();
//        task2.start();
//        task1.start();
//
//        task1.join();
//        task2.join();
//        task3.join();
//        task4.join();
//        task5.join();
//
//        System.out.println("Общее количество -> "
//                +(task1.getCount()
//                +task2.getCount()
//                +task3.getCount()
//                +task4.getCount()
//                +task5.getCount())
//                );



        System.out.println(Thread.currentThread().getName()+" -> Main Time = "+(System.currentTimeMillis()-startTime));
        System.out.println(" - End - ");

    }
}

class ThreadTaskAtomic extends Thread {
    private int start;
    private int end;

    private AtomicInteger count;

    public AtomicInteger getCount() {
        return count;
    }

    public ThreadTaskAtomic(int start, int end, AtomicInteger counter) {
        this.start = start;
        this.end = end;
        this.count = counter;
    }

    public void run() {

        long startTime = System.currentTimeMillis();

        for (int i = start; i < end; i++) {
            boolean isPrime = true;

            for (int j=2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                count.incrementAndGet();
//                System.out.println(i);
            }
        }
        System.out.println(Thread.currentThread().getName()+" -> Count = "+count.get()+"  --- "+start+"..."+end);
        System.out.println(Thread.currentThread().getName()+" -> Time = "+(System.currentTimeMillis()-startTime));
    }
}
class ThreadTask extends Thread {
    private int start;
    private int end;

    private int count;

    public int getCount() {
        return count;
    }

    public ThreadTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public void run() {
        count = 0;

        long startTime = System.currentTimeMillis();

        for (int i = start; i < end; i++) {
            boolean isPrime = true;

            for (int j=2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                count++;
//                System.out.println(i);
            }
        }
        System.out.println(Thread.currentThread().getName()+" -> Count = "+count+"  --- "+start+"..."+end);
        System.out.println(Thread.currentThread().getName()+" -> Time = "+(System.currentTimeMillis()-startTime));
    }
}
