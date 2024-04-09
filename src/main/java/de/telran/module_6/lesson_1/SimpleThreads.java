package de.telran.module_6.lesson_1;

public class SimpleThreads {
    public static void main(String[] args) throws InterruptedException {

        MyThread myThread = new MyThread();
//        myThread.run(); // не правильно
        myThread.start();

        MyThreadRunnable myThreadRunnable = new MyThreadRunnable();
        Thread thread = new Thread(myThreadRunnable);
        thread.start();

        Thread threadAnonim = new Thread() {
            public void run() {

                try {
                    System.out.println("Run task Anonim -> "+Thread.currentThread().getName());
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("End Task Anonim -> "+Thread.currentThread().getName());
            }
        };
        threadAnonim.start();

        Runnable runnable = () -> {
                try {
                    System.out.println("Run task AnonimRunnable -> "+Thread.currentThread().getName());
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("End Task AnonimRunnable -> "+Thread.currentThread().getName());
        };
        Thread threadAninimRunnable = new Thread(runnable);
        threadAninimRunnable.start();

        myThread.join();
        thread.join();


        System.out.println(" -- Главный поток заканчивает работы --");
    }
}

class MyThread extends Thread {
 public void run() {

     try {
         System.out.println("Run task -> "+Thread.currentThread().getName());
         Thread.sleep(3000);
     } catch (InterruptedException e) {
         throw new RuntimeException(e);
     }

     System.out.println("End Task -> "+Thread.currentThread().getName());
 }

}

class MyThreadRunnable implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println("Run task Runnable -> "+Thread.currentThread().getName());
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("End Task Runnable -> "+Thread.currentThread().getName());
    }
}

