package de.telran.module_6.lesson_4.ht;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class SimpleRobotBlockingQueue {
    public static void main(String[] args) {
        BlockingQueue<Integer> drop = new SynchronousQueue<Integer>();
//        BlockingQueue<Integer> drop = new ArrayBlockingQueue<Integer>(1, true);
        (new Thread(new Producer(drop))).start();
        (new Thread(new Consumer(drop))).start();
    }
}

class Producer implements Runnable
{
    private BlockingQueue<Integer> drop;
    public Producer(BlockingQueue<Integer> drop) {
        this.drop = drop;
    }

    public void run() {
        try {
            for (int i=0; i<10; i++) {
                System.out.println("Положили ящик номер = "+i);
                drop.put(i);
               Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }
}

class Consumer implements Runnable
{
    private BlockingQueue<Integer> drop;
    public Consumer(BlockingQueue<Integer> drop) {
        this.drop = drop;
    }
    public void run() {
        try {
            for (int i=0; i<10; i++) {
                Thread.sleep(500);
                System.out.println("Унесли ящик номер = "+drop.take());
            }
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }
}
