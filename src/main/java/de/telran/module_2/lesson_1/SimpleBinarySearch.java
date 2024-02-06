package de.telran.module_2.lesson_1;

import java.util.Arrays;

public class SimpleBinarySearch {
    public static void main(String[] args) {
        // инициализация c помощью литерала
        int[] arr2 = {8,7,1,2,3,4,5};
        Arrays.sort(arr2);
        System.out.println(Arrays.binarySearch(arr2, 7));

        System.out.println(binarySearch(arr2, 0, arr2.length-1, 7));
    }

    public static int binarySearch(int[] arr, int leftIdx, int rightIdx, int element) {
        if (rightIdx >= leftIdx) {

            int mid = leftIdx + (rightIdx - leftIdx) / 2;

            if (arr[mid] == element) {
                return mid;
            }

            if (arr[mid] > element)
                return binarySearch(arr, leftIdx, mid - 1, element);

            return binarySearch(arr, mid + 1, rightIdx, element);
        }
        return -1;
    }

}
