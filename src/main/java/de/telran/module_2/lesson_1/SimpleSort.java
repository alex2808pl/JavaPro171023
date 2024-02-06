package de.telran.module_2.lesson_1;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class SimpleSort {
    public static void main(String[] args) {
        // инициализация c помощью литерала
        int[] arr2 = {8,7,1,2,3,4,5};
        System.out.println(Arrays.toString(arr2));

        Arrays.sort(arr2);
        System.out.println(Arrays.toString(arr2));

//        Collections.sort();// работает только с коллекциями.
    }
}
