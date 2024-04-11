package de.telran.module_6.lesson_2;

public class SimpleStates {
    //    NEW
    //    RUNNABLE
    //    TERMINATED
    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("2."+getState());
            }
        };
        System.out.println("1."+thread.getState());
        thread.start();
        try {
            // Тут маленькая сложность есть только для вывода состояния TERMINATED:
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("3."+thread.getState());
    }
}
