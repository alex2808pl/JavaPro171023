package de.telran.preparation.multi.test;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class SimpleSumThreads3 {
        public static void main (String[]args) throws InterruptedException {

            Scanner scanner = new Scanner(System.in);

            Chicken_Thread chickenThread = new Chicken_Thread();
            Egg_Thread eggThread = new Egg_Thread();

            System.out.println("Кто же первый?");
            chickenThread.start();
            eggThread.start();

//            Thread.sleep(3000);
//            chickenThread.setPaused(true);
//            eggThread.setPaused(true);
//            Thread.sleep(3000);

            System.out.println("Кто же прав?");
            int choice = scanner.nextInt();

//            chickenThread.setPaused(false);
//            eggThread.setPaused(false);
//            Thread.sleep(3000);

            if (choice == 1) {
                eggThread.interrupt();
//                System.out.println("Победила курица :)");
//                chickenThread.interrupt();
            } else if (choice == 2) {
                chickenThread.interrupt();
//                System.out.println("Победило яйцо :)");
//                eggThread.interrupt();
            } else {
                eggThread.interrupt();
                chickenThread.interrupt();
                System.out.println("Как же вы надоели!");
            }
        }
    }


    class Chicken_Thread extends Thread{

        private boolean isPaused = false;

        public boolean isPaused() {
            return isPaused;
        }

        public void setPaused(boolean paused) {
            isPaused = paused;
        }

        public void run() {
            Thread.currentThread().setName("Thread Chicken");

            while (!Thread.interrupted()) {
                System.out.println("Курица");
                while (isPaused){
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        System.out.println(Thread.currentThread().getName() + " был прерван.");
                        if (Thread.interrupted()){
                            return;
                        }
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " был прерван.");
                    return;
                }

            }
        }
    }
class Egg_Thread extends Thread{

    private boolean isPaused = false;

    public boolean isPaused() {
        return isPaused;
    }

    public void setPaused(boolean paused) {
        isPaused = paused;
    }

    public void run() {
        Thread.currentThread().setName("Thread Egg");

        while (!Thread.interrupted()) {
            System.out.println("Яйцо");
            while (isPaused){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " был прерван.");
                    if (Thread.interrupted()){
                        return;
                    }
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " был прерван.");
                return;
            }
        }
    }
}