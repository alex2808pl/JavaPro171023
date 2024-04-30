package de.telran.module_6.lesson_7;

public class SimpleThreads {
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            Thread tread = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+" стартовал!");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName()+" закончил!");

                }
            });
            tread.start();
        }


    }
}
