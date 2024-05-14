package de.telran.module_7.lesson_3.reflection;

class Sample
{
    public String publ;
    // Создаем приватное поле private
    String s;
    private String priv;
    // Создаем публичный конструктор
    public Sample() { s = "Java Reflection API"; }

    public Sample(String s, String priv) {
        this.s = s;
        this.priv = priv;
    }

    // Создаем публичный метод без параметров
    public void method1() {
        System.out.println("Информация в строке — " + s); }

    // Создаем публичный метод с целым числом в качестве параметра
    public void method2(int x) {
        System.out.println("Целое число — " + x);
    }
    public void method5(int x, double y) {
        System.out.println("Результат — " + (x+y));
    }
    public void method4(int... x) { //int[] x
        for (int el : x) {
            System.out.println("элемент — " + el);
        }

    }

    // Создаем приватный метод
    private void method3() {
        System.out.println("Вызов приватного метода");
    }
}