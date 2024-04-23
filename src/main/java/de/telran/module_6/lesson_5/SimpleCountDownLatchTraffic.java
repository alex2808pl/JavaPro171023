package de.telran.module_6.lesson_5;
// пример применения CountDownLatch в процессе отправления людей в отпуск, у нас 8 человек, которые
// желают отправиться в отпуск. В аэропорту они выполняют обычные действия, такие как регистрация,
// сдача багажа. Делают они это по отдельности, а после этого уже группой садятся в самолет и вылетают

import java.util.concurrent.CountDownLatch;

public class SimpleCountDownLatchTraffic {
    public static void main(String[] args) throws Exception {

        CountDownLatch countDownLatch = new CountDownLatch(3);

        Thread service1 = new Thread(new Service("Скорая", countDownLatch, 3000));
        Thread service2 = new Thread(new Service("Полиция", countDownLatch, 5000));
        Thread service3 = new Thread(new Service("Дорожная служба", countDownLatch, 8000));

        for (int i = 0; i < 10; i++) {
            new Thread(new Auto(countDownLatch)).start();
            Thread.sleep(700);
        }
        service1.start();
        service2.start();
        service3.start();

    }
}

class Service implements Runnable {
    private String personName;
    private CountDownLatch countDownLatch;

    private int time;

    public Service(String personName, CountDownLatch countDownLatch, int time) {
        this.personName = personName;
        this.countDownLatch = countDownLatch;
        this.time = time;
    }

    @Override
    public void run() {

        try {
            System.out.println("-> " + personName + " начинает свою работу!");
            Thread.sleep(time);
            System.out.println(personName+" закончила работу.");
            countDownLatch.countDown(); //-1
         } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Auto implements Runnable {
    private CountDownLatch countDownLatch;

    public Auto(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {

        try {
            System.out.println(Thread.currentThread().getName()+" авто подьехала к проблемному участку!");
            countDownLatch.await();
            System.out.println(Thread.currentThread().getName()+" авто едет дальше!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}