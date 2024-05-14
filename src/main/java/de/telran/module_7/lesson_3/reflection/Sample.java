package de.telran.module_7.lesson_3.reflection;

class Sample
{
    // Создаем приватное поле private
    String s;
    private String priv;
    // Создаем публичный конструктор
    public Sample() { s = "Java Reflection API"; }
    // Создаем публичный метод без параметров
    public void method1() {
        System.out.println("Информация в строке — " + s); }
    // Создаем публичный метод с целым числом в качестве параметра
    public void method2(int x) {
        System.out.println("Целое число — " + x);
    }
    // Создаем приватный метод
    private void method3() {
        System.out.println("Вызов приватного метода");
    }
}