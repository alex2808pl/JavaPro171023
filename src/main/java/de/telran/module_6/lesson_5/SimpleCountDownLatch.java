package de.telran.module_6.lesson_5;
// пример применения CountDownLatch в процессе отправления людей в отпуск, у нас 8 человек, которые
// желают отправиться в отпуск. В аэропорту они выполняют обычные действия, такие как регистрация,
// сдача багажа. Делают они это по отдельности, а после этого уже группой садятся в самолет и вылетают

import java.util.concurrent.CountDownLatch;

public class SimpleCountDownLatch {
    public static void main(String[] args) throws Exception {

        CountDownLatch countDownLatch = new CountDownLatch(8);

        // список людей, кто желает полететь на отдых
        String[] personNames = new String[]{"Roman", "Alena", "Kira", "Anna", "Leo", "Bob", "Vladislav", "Inna"};

        for (int i = 0; i < personNames.length; i++) {
            new Thread(new PersonInAirport(personNames[i], countDownLatch)).start();
            Thread.sleep(700);
        }

    }
}

class PersonInAirport implements Runnable {
    private String personName;
    private CountDownLatch countDownLatch;

    public PersonInAirport(String personName, CountDownLatch countDownLatch) {
        this.personName = personName;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {

        try {
            // список дел, которые буду выполнены в рамках каждого потока (человека) самостоятельно
            System.out.println("-> " + personName + " приехал в аэропорт.");
            System.out.println("[!] " + personName + " сдал багаж");
            System.out.println("[!] " + personName + " успел перекусить");

            countDownLatch.countDown(); //-1

            System.out.println(personName+" ожидает других.");
            countDownLatch.await(); // когда count==0 все выходят из состояния ожидания

            // финальное - выполнится то, что находится после await() метода
            System.out.println(personName + " с группой пошел на посадку в самолет");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}