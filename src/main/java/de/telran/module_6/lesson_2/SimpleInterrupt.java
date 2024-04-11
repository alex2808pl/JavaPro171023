package de.telran.module_6.lesson_2;

public class SimpleInterrupt {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main - начал работу.");

        // Создаем анонимный класс потока
        Thread t = new Thread(()->{
            for (int  j= 0; j < 10; j++) {
                System.out.println(Thread.currentThread().getName()+" работает "+j+" раз");
                try {
                    System.out.println(Thread.currentThread().getName()+" сам засыпает "+j+" раз");
                    Thread.sleep(2000); // засыпает на 2 сек
                    System.out.println(Thread.currentThread().getName()+" сам просыпается "+j+" раз");

                    if(Thread.interrupted()) {// проверка isInterrupted
                        System.out.println("Закрываем сами поток по просьбе, выполнялся "+j+" раз.");
                        // своя логика
                        return; // завершаем работу потока, если необходимо!
                    }
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException - проснулся принудительно "+j+" раз.");
                    // своя логика
                    return; // завершаем работу потока, если необходимо!
//                    throw new RuntimeException(e);
                }
            }
        });
        t.start();
        System.out.println("до isInterrupted - "+t.isInterrupted());
        Thread.sleep(6000);
        t.interrupt(); // будит поток, если он спал или ожидал, срывая команды sleep, wait, join
        Thread.sleep(3000);
        t.interrupt();
        // t.stop(); // запрещенная операция остановки работы протока
        System.out.println("после isInterrupted - "+t.isInterrupted());

        System.out.println("Main - закончил работу.");
    }
}
