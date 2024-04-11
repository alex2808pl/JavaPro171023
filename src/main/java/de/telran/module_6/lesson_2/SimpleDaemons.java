package de.telran.module_6.lesson_2;

public class SimpleDaemons {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main - начал работу.");
        for (int i = 0; i < 3; i++) {
             Thread t = new Thread(()->{
                for (int  j= 0; j < 10; j++) {
                    System.out.println(Thread.currentThread().getName()+" работает "+j+" раз");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            t.setDaemon(true);
            t.start();
        }
//
//        for (int i = 0; i < 3; i++) {
//           MyThread t1 = new MyThread();
////           t1.setDaemon(false);
//           t1.start();
//        }
        Thread.sleep(3000);
        System.out.println("Main - закончил работу.");
    }
}

class MyThread extends Thread {
    public void run() {

        for (int  j= 0; j < 10; j++) {
            System.out.println(Thread.currentThread().getName()+" работает "+j+" раз");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("End Task -> "+Thread.currentThread().getName());
    }

}
