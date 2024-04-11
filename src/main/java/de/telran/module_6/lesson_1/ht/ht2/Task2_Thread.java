package de.telran.module_6.lesson_1.ht.ht2;

public class Task2_Thread extends Thread {

//  2*. Посчитайте количество всех целых чисел в диапазоне от Integer.MIN_VALUE до Integer.MAX_VALUE,
//  которые делятся на введенное пользователем число number без остатка.
//  Просчитайте время, которое необходимо для вычисления данного результата в одном потоке.
//  Просчитайте время, которое необходимо пользователю для выполнения этих задачи параллельно,
//  количество создаваемых потоков countThreads пользователь тоже должен ввести вручную.

    private long start;
    private long end;
    private int number;
    private long count = 0;

    public Task2_Thread(long start, long end, int number) {
        this.start = start;
        this.end = end;
        this.number = number;
    }

    public long getCount() {
        return count;
    }

    public void run() {
        for (long i = start; i <= end ; i++) {
            if (i % this.number == 0){
                count++;
            }
        }
        System.out.println(Thread.currentThread().getName() + " - Количество целых чисел, которые делятся на " + number + " без остатка: " + count);
    }
}