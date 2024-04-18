package de.telran.module_6.lesson_4;

import java.util.concurrent.atomic.AtomicInteger;

public class SimpleWaitNotify {
    public static void main(String[] args) throws InterruptedException {

        AtomicInteger data = new AtomicInteger(0);

        Thread waiter = new Waiter(data);
        Thread job = new Job(data);
        waiter.start();
        job.start();

        waiter.join();

        System.out.println("Заканчиваю главный поток = "+data.get());


    }
}

class Waiter  extends Thread {
    private AtomicInteger data;

    public Waiter(AtomicInteger data) {
        this.data = data;
    }

    @Override
    public void run() {
        System.out.println("Поток Waiter стартовал.");
        // Проверил что-то и понял что ему нужно подождать
        synchronized (data) {
            try {
                if(data.get()<=0) {
                    data.wait();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        // Обработал информацию

        System.out.println("Я дополнительно обрабатываю результат -> "+data.get());
        data.addAndGet(1_000_000);

        System.out.println("Поток Waiter закончил работу.");
    }
}

class Job  extends Thread {
    private AtomicInteger data;

    public Job(AtomicInteger data) {
        this.data = data;
    }

    @Override
    public void run() {
        System.out.println("Поток Job стартовал.");
        // Работает над информацией
        int sum = 0;
        for (int i=0; i<100_000; i++) {
            if(i % 13 == 0)
                sum+=i;
        }
        data.addAndGet(sum);
        synchronized (data) {
            data.notify();
        }
        System.out.println("Поток Job закончил работу.");
    }
}
