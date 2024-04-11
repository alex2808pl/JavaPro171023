package de.telran.module_6.lesson_1.ht.ht2;

import java.util.Scanner;

public class ht2 {
    //  2*. Посчитайте количество всех целых чисел в диапазоне от Integer.MIN_VALUE до Integer.MAX_VALUE,
//  которые делятся на введенное пользователем число number без остатка.
//  Просчитайте время, которое необходимо для вычисления данного результата в одном потоке.
//  Просчитайте время, которое необходимо пользователю для выполнения этих задачи параллельно,
//  количество создаваемых потоков countThreads пользователь тоже должен ввести вручную.
//

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число, на которое нужно поделить: ");
        int number = scanner.nextInt();

//        long startTime = System.currentTimeMillis();
//        countIntegerNumbers(number);
//        long endTime = System.currentTimeMillis();
//
//        System.out.println("Поток main - всего затрачено: " + (endTime - startTime) + "миллисекунд.");

        //Многопоточность
         int countThreads = 0;
        while (countThreads < 1) {
            System.out.print("Введите количество потоков для обработки задачи: ");
            countThreads = scanner.nextInt();
        }

        long startTimeThreads = System.currentTimeMillis();

        long interval = ((long) Integer.MAX_VALUE - (long) Integer.MIN_VALUE) / countThreads;
        long start = Integer.MIN_VALUE;
        long end = start + interval;

        Task2_Thread[] threadArray = new Task2_Thread[countThreads];

        for (int i = 0; i < countThreads; i++) {
            threadArray[i] = new Task2_Thread(start, end, number);
            threadArray[i].start();
            //threadArray[i].join(); // НЕЛЬЗЯ
            System.out.println("Поток " + i + " запущен: от " + start + " до " + end);

            start = end + 1;
            end = start + interval - 1;
            if (i == (countThreads - 2)) {
                end = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < countThreads; i++) {
            try {
                threadArray[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        long resultCount = 0;
        for (int i = 0; i < countThreads; i++) {
            resultCount = resultCount + threadArray[i].getCount();
        }

        System.out.println("Общее количество целых чисел, которые делятся на " + number + " без остатка: " + resultCount);

        long endTimeThreads = System.currentTimeMillis();
        System.out.println(countThreads + " потоков - всего затрачено: " + (endTimeThreads - startTimeThreads) + "миллисекунд.");
    }

    public static void countIntegerNumbers(int number) {
        int count = 0;
        for (int i = Integer.MIN_VALUE; i < Integer.MAX_VALUE; i++) {
            if (i % number == 0) {
                count++;
            }
        }
        System.out.println("Количество целых чисел, которые делятся на " + number + " без остатка: " + count);
    }
}
