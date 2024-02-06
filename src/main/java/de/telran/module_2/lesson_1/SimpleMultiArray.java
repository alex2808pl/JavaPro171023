package de.telran.module_2.lesson_1;

import java.util.Arrays;

public class SimpleMultiArray {
    public static void main(String[] args) {
        // инициализация по умолчанию
        int[][] arr;
        arr = new int[2][3];
        System.out.println(Arrays.deepToString(arr));

        // инициализация руками
        String[][] arrStr = new String[2][3];
        for (int i = 0; i < arrStr.length ; i++) {
            for (int j = 0; j < arrStr[i].length; j++) {
                arrStr[i][j] = ""+(i+1)+(j+1);
            }
        }
        System.out.println(Arrays.deepToString(arrStr));

        // инициализация c помощью литерала
       int[][] arr1 = {{1,2,3,4,5},{6,7,8,9,10}};
       System.out.println(Arrays.deepToString(arr1));

       //зубчатые массивы
       int[][] arr2 = {{1,2}, {3,4,5},{6},{7,8,9,10}};
        System.out.println(Arrays.deepToString(arr2));

        //изменение данных
        arr2[0][1] = 11;
        System.out.println(Arrays.deepToString(arr2));

        arr2[1][2] = 14;
        System.out.println(Arrays.deepToString(arr2));

        for (int i = 0; i < arr2.length ; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                arr2[i][j] = arr2[i][j]*10;
            }
        }
        System.out.println(Arrays.deepToString(arr2));

        // вторая модель для вывода данных
        for (int[] ar : arr2) {
            for (int el: ar){
                System.out.println(el);
                el = 333;  // не работает
            }
        }
        System.out.println(Arrays.deepToString(arr2));

        // вторая модель изменения данных
        for (int[] ar : arr2) {
            for (int j = 0; j < ar.length; j++) {
                ar[j] = ar[j]*10; //все работает
            }
        }
        System.out.println(Arrays.deepToString(arr2));

        //трехмерные массивы
        int[][][] arr3 = new int[2][2][3];
        for (int[][] ar2 : arr3) {
            for (int[] ar1 : ar2) {
                for (int j = 0; j < ar1.length; j++) {
                    ar1[j] = 1 + j; //все работает
                }
            }

        }
        System.out.println(Arrays.deepToString(arr3));

        for (int i = 0; i < arr3.length ; i++) {
            for (int j = 0; j < arr3[i].length; j++) {
                for (int k = 0; k < arr3[i][j].length; k++) {
                    arr3[i][j][k] = arr3[i][j][k] * 10;
                }
            }
        }
        System.out.println(Arrays.deepToString(arr3));

        // инициализация c помощью литерала
        int[][][] arr3l = {{{1,2},{3,4}},{{5,6},{7,8}}};
        System.out.println(Arrays.deepToString(arr3l));

    }
}
