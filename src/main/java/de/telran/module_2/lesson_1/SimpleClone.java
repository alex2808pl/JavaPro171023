package de.telran.module_2.lesson_1;

import java.util.Arrays;

public class SimpleClone {
    public static void main(String[] args) {
        // инициализация c помощью литерала
        int[] arr = {6,7,8,9,10};
        System.out.println(Arrays.toString(arr));

        int[] arrClone = arr.clone();
        System.out.println(Arrays.toString(arrClone));

        System.out.println(arr == arrClone);
        System.out.println(arr.equals(arrClone)); // не переопределено в массивах, используется от Object
        System.out.println(Arrays.equals(arr, arrClone));

        arr[2] = 11; //меняется только в источнике, клон не меняется
        System.out.println(Arrays.equals(arr, arrClone));
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arrClone));

        // инициализация c помощью литерала 2-мерного массива
        int[][] arr2 = {{1,2,3,4,5},{6,7,8,9,10}};
        System.out.println(Arrays.deepToString(arr2));

        int[][] arr2Clone = arr2.clone(); // поверхностное копирование
        System.out.println(Arrays.deepToString(arr2Clone));

        arr2[0][2]= 11;
        System.out.println(Arrays.deepToString(arr2));
        System.out.println(Arrays.deepToString(arr2Clone));

        System.out.println(arr2 == arr2Clone);
        System.out.println(Arrays.equals(arr2, arr2Clone));
        System.out.println(Arrays.deepEquals(arr2, arr2Clone));

    }
}


