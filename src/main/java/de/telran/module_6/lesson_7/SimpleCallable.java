package de.telran.module_6.lesson_7;

import java.util.Calendar;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class SimpleCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> task1 = new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(2000);
                return "Hello, World! Anonym";
            }
        };

        Callable task = () -> {
            Thread.sleep(2000);
            return "Hello, World! Lambda";
        };
        FutureTask<String> future = new FutureTask<>(task);
        new Thread(future).start();
        System.out.println(future.get());

        FutureTask<String> future1 = new FutureTask<>(task1);
        new Thread(future1).start();
        System.out.println(future1.get());
    }
}
