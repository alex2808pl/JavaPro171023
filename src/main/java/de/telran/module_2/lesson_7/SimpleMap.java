package de.telran.module_2.lesson_7;

import java.util.*;

public class SimpleMap {
    public static void main(String[] args) {
        Map<Integer, String> map1 = new TreeMap<>();
        System.out.println(map1.put(2, "Наша 2"));
        map1.put(1, "Наша 1");
        map1.put(5, "Наша 5");
        map1.put(3, "Наша 3"); // добавление данных
//        map1.put(null, "Наш null"); // нельзя использовать null  в качестве ключа
        map1.put(0, "Наш новый 0");
        System.out.println(map1);

        Map<Integer, String> map2  = new TreeMap<>(Comparator.reverseOrder());
        map2.putAll(map1);
        System.out.println(map2);
        // map1.put(null, "Наш null");

        System.out.println(map2.put(3, "Наша новая 3")); //изменение существующих данных
        System.out.println(map2);

        map2.put(3, "Наша сверхновая 3");  //изменение существующих данных
        map2.put(4,"Наша 4"); // вставка нового значения
        map2.put(17, "Наша 17");
        System.out.println(map2);

        for (Map.Entry<Integer, String> entry : map2.entrySet()) {
            System.out.println(entry.getKey()+" -> "+entry.getValue()/* " ==> "+entry.getClass() */);
        }

        // LinkedHashMap
        Map<Integer, String> map3 = new LinkedHashMap<>();
        System.out.println(map3.put(2, "Наша 2"));
        map3.put(1, "Наша 1");
        map3.put(5, "Наша 5");
        map3.put(3, "Наша 3"); // добавление данных
        map3.put(17, "Наша 17");
        map3.put(null, "Наш null");
        map3.put(0, "Наш новый 0");
        System.out.println(map3);

        // HashMap - порядок хранения не гарантирован
        Map<Integer, String> map4 = new HashMap<>();
        System.out.println(map4.put(2, "Наша 2"));
        map4.put(1, "Наша 1");
        map4.put(5, "Наша 5");
        map4.put(3, "Наша 3"); // добавление данных
        System.out.println(map4);
        map4.put(17, "Наша 17");
        map4.put(null, "Наш null");
        map4.put(0, "Наш новый 0");
        System.out.println(map4);

        System.out.println(map4.remove(5)); // удаление
        System.out.println(map4);
        System.out.println(map4.get(17)); // получение значения по ключу

        // Итератор
        Iterator<Map.Entry<Integer, String>> itMap = map4.entrySet().iterator();
        while (itMap.hasNext()) {
            Map.Entry<Integer, String> entry = itMap.next();
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key+" -> "+value+" == it");
        }

        System.out.println(map4.keySet()); // перечень ключей
        System.out.println(map4.values()); // перечень value

        Integer[] arrKey = new Integer[10];
        Integer[] arrKey1 = map4.keySet().toArray(arrKey);
        System.out.println(Arrays.toString(arrKey1));

        // нельзя работать с примитивным типом
        /*int[] arrIntKey = new int[10];
        int[] arrIntKey1 = map4.keySet().toArray(arrIntKey);
        System.out.println(Arrays.toString(arrIntKey1));*/

        // Устаревший, полный аналог HashMap по методам (синнхронизированный)
        Hashtable<Integer, String> hashtable1 = new Hashtable<>();
        hashtable1.put(1, "Наша 1");
        hashtable1.put(5, "Наша 5");
        hashtable1.put(3, "Наша 3"); // добавление данных
        hashtable1.put(17, "Наша 17");
        System.out.println(hashtable1);

    }
}
