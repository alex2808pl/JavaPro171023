package de.telran.module_6.lesson_3.atomics;

import java.util.concurrent.atomic.AtomicInteger;

public class SimpleAtomic {

    public static void main(String[] args) throws InterruptedException {

//      показывает классический подход, который не отработает желаемым образом
        // classic
        CounterClassic c = new CounterClassic();

        Thread thread1Classic = new Thread(c, "First");
        Thread thread2Classic = new Thread(c, "Second");

        thread1Classic.start();
        thread2Classic.start();

        thread1Classic.join();
        thread2Classic.join();

        System.out.println("Classic = " + c.getCounter());


//      показываем как можно его решить с synchronized
        // synchronized
        CounterSync cs = new CounterSync();

        Thread thread1Sync = new Thread(cs, "First");
        Thread thread2Sync = new Thread(cs, "Second");

        thread1Sync.start();
        thread2Sync.start();

        thread1Sync.join();
        thread2Sync.join();

        System.out.println("Synchronized = " + cs.getCounter());


//       показываем как работают atomic types, можно заменит на atmoiclong для демонстрации
        // atomic
        CounterAtomic ca = new CounterAtomic();

        Thread thread1Atom = new Thread(ca, "First");
        Thread thread2Atom = new Thread(ca, "Second");

        thread1Atom.start();
        thread2Atom.start();

        thread1Atom.join();
        thread2Atom.join();

        System.out.println("Atomic = " + ca.getCounter());
    }
}



class CounterClassic extends Thread {
    private int counter = 0;

    @Override
    public void run() {

        int max = 1_000_000;

        for (int i = 0; i < max; i++)
            ++counter;
    }

    public int getCounter() {
        return counter;
    }
}

class CounterSync extends Thread {
    private int counter = 0;

    @Override
    public synchronized void run() {

        int max = 1_000_000;

        for (int i = 0; i < max; i++)
            ++counter;
    }

    public int getCounter() {
        return counter;
    }
}


class CounterAtomic extends Thread {
    private AtomicInteger counter = new AtomicInteger();

    @Override
    public synchronized void run() {

        int max = 1_000_000;

        for (int i = 0; i < max; i++)
            counter.addAndGet(1);
    }

    public int getCounter() {
        return counter.get();
    }
}
