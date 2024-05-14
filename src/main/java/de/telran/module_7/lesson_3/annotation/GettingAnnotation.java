package de.telran.module_7.lesson_3.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@HelloAnnotation(value = "Hello", greetTo = "Universe")
public class GettingAnnotation {
    public static void main(String[] args) {
        GettingAnnotation demo = new GettingAnnotation();

        Class<? extends GettingAnnotation> clazz = demo.getClass();
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("Annotation Type: " + annotation.annotationType());
        }

        HelloAnnotation annotation = clazz.getAnnotation(HelloAnnotation.class);
        System.out.println("Value  : " + annotation.value());
        System.out.println("GreetTo: " + annotation.greetTo());

        try {
            Method m = clazz.getMethod("sayHi");

            annotation = m.getAnnotation(HelloAnnotation.class);
            System.out.println("Value  : " + annotation.value());
            System.out.println("GreetTo: " + annotation.greetTo());
            // дополнимтельную логику перед выполнением этого метода
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        demo.sayHello();
    }

    @HelloAnnotation(value = "Hi", greetTo = "Alice")
    public void sayHi() {
    }

    @HelloAnnotation(value = "Hello", greetTo = "Bob")
    public void sayHello() {
        try {
            Method method = getClass().getMethod("sayHello");
            HelloAnnotation annotation = method.getAnnotation(HelloAnnotation.class);

            System.out.println(annotation.value() + " " + annotation.greetTo());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}