package de.telran.module_6.lesson_5;

import java.util.concurrent.Semaphore;

public class SimpleSemaphore {
    public static void main(String[] args) throws InterruptedException {
        // Ограничить количество одновременно работающих потоков
        Semaphore semaphore = new Semaphore(2, true);
        for (int i = 0; i < 10; i++) {
            new Thread(new ThreadTest(semaphore)).start();
            Thread.sleep(500);
        }
    }
}

class ThreadTest implements Runnable
{
    Semaphore semaphore;
    public ThreadTest(Semaphore semaphore) {
        this.semaphore = semaphore;
    }
    public void run() {
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName()+" начал работать "+System.currentTimeMillis());
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName()+" закончил работать");
            semaphore.release();
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }
}

