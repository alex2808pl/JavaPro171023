package de.telran;

import java.lang.reflect.Array;
import java.util.*;

public class TestMain {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            integers.add(i, i);
        }
        System.out.println(integers.size());

        long startTime = System.currentTimeMillis();
        for (Integer n : integers) {
            int temp = n;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("for each loop: " + (endTime - startTime) + " ArrayList");

        long startTime1 = System.currentTimeMillis();
        for (int i = 0; i < integers.size(); i++) {
            int temp = i;
        }
        long endTime1 = System.currentTimeMillis();
        System.out.println("for i loop: " + (endTime1 - startTime1) + " ArrayList");

        long startTime2 = System.currentTimeMillis();
        for (int i = integers.size(); i >= 0 ; i--) {
            int temp = i;
        }
        long endTime2 = System.currentTimeMillis();
        System.out.println("for i loop reverse: " + (endTime2 - startTime2) + " ArrayList");

        Iterator<Integer> iterator = integers.iterator();
        long startTime3 = System.currentTimeMillis();
        while (iterator.hasNext()){
            int temp = iterator.next();
        }
        long endTime3 = System.currentTimeMillis();
        System.out.println(" for iterator loop: " + (endTime3 - startTime3) + " ArrayList");

        ListIterator<Integer> listIterator = integers.listIterator();

        long startTime4 = System.currentTimeMillis();
        while (listIterator.hasNext()){
            int temp = listIterator.next();
        }
        long endTime4 = System.currentTimeMillis();
        System.out.println(" for listIterator loop: " + (endTime4 - startTime4) + " ArrayList");

        long startTime5 = System.currentTimeMillis();
        while (listIterator.hasPrevious()){
            int temp = listIterator.previous();
        }
        long endTime5 = System.currentTimeMillis();
        System.out.println(" for listIterator loop reverse: " + (endTime5 - startTime5) + " ArrayList"  );



        List<Integer> integers1 = new LinkedList<>();
        for (int i = 0; i < 10000000; i++) {
            integers1.add(i, i);
        }
        System.out.println(integers.size());

        long startTime11 = System.currentTimeMillis();
        for (Integer n : integers1) {
            int temp = n;
        }
        long endTime11 = System.currentTimeMillis();
        System.out.println("for each loop: " + (endTime11 - startTime11) + " LinkedList");

        long startTime12 = System.currentTimeMillis();
        for (int i = 0; i < integers1.size(); i++) {
            int temp = i;
        }
        long endTime12 = System.currentTimeMillis();
        System.out.println("for i loop: " + (endTime12 - startTime12) + " LinkedList");

        long startTime13 = System.currentTimeMillis();
        for (int i = integers1.size(); i >= 0 ; i--) {
            int temp = i;
        }
        long endTime13 = System.currentTimeMillis();
        System.out.println("for i loop reverse: " + (endTime13 - startTime13) + " LinkedList");

        Iterator<Integer> iterator1 = integers1.iterator();
        long startTime14 = System.currentTimeMillis();
        while (iterator1.hasNext()){
            int temp = iterator1.next();
        }
        long endTime14 = System.currentTimeMillis();
        System.out.println(" for iterator loop: " + (endTime14 - startTime14) + " LinkedList");

        ListIterator<Integer> listIterator1 = integers1.listIterator();

        long startTime15 = System.currentTimeMillis();
        while (listIterator1.hasNext()){
            int temp = listIterator1.next();
        }
        long endTime15 = System.currentTimeMillis();
        System.out.println(" for listIterator loop: " + (endTime15 - startTime15) + " LinkedList");

        long startTime16 = System.currentTimeMillis();
        while (listIterator1.hasPrevious()){
            int temp = listIterator1.previous();
        }
        long endTime16 = System.currentTimeMillis();
        System.out.println(" for listIterator loop reverse: " + (endTime16 - startTime16) + " LinkedList"  );

        System.out.println(690%16);
        System.out.println(391%16);

    }
}
