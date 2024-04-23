package de.telran.module_6.lesson_5;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class SimpleCyclicBarrierCount {
    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

        ThreadTask task1 = new ThreadTask(2, 200000, cyclicBarrier);
        ThreadTask task2 = new ThreadTask(200001, 400000, cyclicBarrier);
        ThreadTask task3 = new ThreadTask(400001, 600000, cyclicBarrier);
        ThreadTask task4 = new ThreadTask(600001, 800000, cyclicBarrier);
        task4.start();
        task3.start();
        task2.start();
        task1.start();

        int count = 0;

        long startTime = System.currentTimeMillis();

        for (int i = 800_001; i < 1_000_000; i++) {
            boolean isPrime = true;

            for (int j=2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                count++;
            }
        }

        cyclicBarrier.await();

        int sum = count+ task1.getCount()+task2.getCount()+task3.getCount()+ task4.getCount();

        System.out.println("Общее количтество = "+sum);

    }
}

class ThreadTask extends Thread {
    private int start;
    private int end;

    private int count;

    private CyclicBarrier cyclicBarrier;

    public ThreadTask(int start, int end, CyclicBarrier cyclicBarrier) {
        this.start = start;
        this.end = end;
        this.cyclicBarrier = cyclicBarrier;
    }

    public void run() {
        count = 0;

        long startTime = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName()+" -> start.");

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
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }

    public int getCount() {
        return count;
    }
}