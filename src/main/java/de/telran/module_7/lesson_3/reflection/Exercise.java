package de.telran.module_7.lesson_3.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class Exercise {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException, ClassNotFoundException, InstantiationException {
        // Создаем объект для последующей проверки свойств
        Sample obj = new Sample();
// Создаем новый объект класса из другого объекта
        Class cls = obj.getClass();
        System.out.println("Имя класса — " +
                cls.getName());
        System.out.println("Имя класса (короткое)— " +
                cls.getSimpleName());
// Получаем имя конструктора класса с помощью объекта
        Constructor constructor = cls.getConstructor();
        System.out.println("Имя конструктора по умолчанию — " +
                constructor.getName());
        Constructor[] constructors = cls.getConstructors();
        for (Constructor constr :constructors) {
            System.out.println("Имя конструктора — " +
                    constructor.getName());
        }

        System.out.println("Это публичные методы классов: ");
// Получаем методы классов с помощью объектов
        Method[] methods = cls.getDeclaredMethods();//.getMethods();
// Выводим имена методов
        for (Method method:methods)
            System.out.println(method.getName());

// Создаем объект нужного метода с помощью имени метода и параметра класса
        Method methodcall1 = cls.getDeclaredMethod("method2", int.class);
// Вызов метода во время исполнения
        methodcall1.invoke(obj, 25);
// Создаем объект нужного метода с помощью имени метода и параметра класса
        Method methodcall2 = cls.getDeclaredMethod("method5", int.class, double.class);
// Вызов метода во время исполнения
        methodcall2.invoke(obj, 25, 13.01);

 //        obj.method4(3,7,9,11);

        // Получаем перечень всех публичных характеристик класса
        Field[] fields = cls.getFields();
        for (Field f : fields) {
            System.out.println(f.getName());
        }

        System.out.println();
        // Получаем перечень всех публичных характеристик класса
        fields = cls.getDeclaredFields();
        for (Field f : fields) {
            System.out.println(f.getName());
        }

// Создаем объект нужного поля с помощью имени поля
        Field field = cls.getDeclaredField("s");
// Устанавливаем новое значение поля
        System.out.println("s = "+obj.s);
        field.set(obj, "Tel-Ran");
        System.out.println(field.getName() + " = "+obj.s);

        field = cls.getDeclaredField("priv");
        // Открываем доступ к полю независимо от используемого в нем спецификатора доступа
        field.setAccessible(true);
        // Устанавливаем новое значение поля
        System.out.println("priv = "+field.get(obj));
        field.set(obj, "newPriv");
        System.out.println(field.getName() + " = "+field.get(obj));

// Создаем объект метода с помощью имени метода
        Method methodcall4 = cls.getDeclaredMethod("method1");
// Вызов метода во время исполнения
        methodcall4.invoke(obj);
// Создаем третий объект метода с помощью имени метода
        Method methodcall3 = cls.getDeclaredMethod("method3");
// Изменяем настройки доступа
        methodcall3.setAccessible(true);
// Вызов метода во время исполнения
        methodcall3.invoke(obj);

        //Создание объекта класса c помощью Reflection
        Class clazz = Class.forName(Sample.class.getName());
        Class[] params = {String.class, String.class};
        Sample sampleRefl = (Sample) clazz.getConstructor(params).newInstance("argS", "argPriv");
        sampleRefl.method1();

    }
}
