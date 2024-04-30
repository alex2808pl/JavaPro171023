package de.telran.module_6.lesson_7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleThreadPool {
    public static void main(String[] args) {
        //ExecutorService executorService = Executors.newFixedThreadPool(3); //ограничен МАX количество
        ExecutorService executorService = Executors.newSingleThreadExecutor(); //всегда только один поток
        for (int i = 0; i < 30; i++) {
            executorService.execute(new Task(i));
        }

        executorService.shutdown();
    }
}

class Task implements Runnable {
    int taskNumber;

    public Task(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Обработан запрос пользователя №" + taskNumber + " на потоке " + Thread.currentThread().getName());
    }
}
