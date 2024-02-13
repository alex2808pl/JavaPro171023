package de.telran.module_2.lesson_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SimpleIterator {
    public static void main(String[] args) {
        List<Integer> listInt = List.of(1,2,3,4,5,6,7,8,9);
        for (int i = 0; i < listInt.size(); i++) {
            System.out.print(listInt.get(i)+",");
        }
        System.out.println();
        // не индексный доступ
        for (Integer el : listInt) { //Iterable
            System.out.print(el+",");
        }

        System.out.println();
        Iterator<Integer> it = listInt.iterator();
        while(it.hasNext()) {
            Integer el = it.next();
            System.out.print(el+",");
        }

        System.out.println();
//        it = listInt.iterator();
//        while(it.hasNext()) {
//            Integer el = it.next();
//            if(el % 2 !=0 ) {
//                it.remove(); //UnsupportedOperationException
//                continue;
//            }
//            System.out.print(el+",");
//        }

        List<Integer> arrayList = new ArrayList<>(Arrays.asList(9,8,7,6,5,4,3,2,1));
        it = arrayList.iterator();
        while(it.hasNext()) {
            Integer el = it.next();
            if(el % 2 !=0 ) {
                it.remove(); //удаляем объект
                continue;
            }
            System.out.print(el+",");
        }
        System.out.println();
        System.out.println(arrayList);

    }
}
