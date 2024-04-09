package de.telran.module_6.lesson_1;

import java.util.TreeSet;

public class SimpleTaskMultithread {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(" - Start - ");
        long startTime = System.currentTimeMillis();

        ThreadTask task1 = new ThreadTask(2, 200000);
        ThreadTask task2 = new ThreadTask(200001, 400000);
        ThreadTask task3 = new ThreadTask(400001, 600000);
        ThreadTask task4 = new ThreadTask(600001, 800000);
        ThreadTask task5 = new ThreadTask(800_001, 1_000_000);

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

        System.out.println(Thread.currentThread().getName()+" -> Main Time = "+(System.currentTimeMillis()-startTime));
        System.out.println(" - End - ");

    }
}

class ThreadTask extends Thread {
    private int start;
    private int end;

    public ThreadTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public void run() {
        int count = 0;

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
