package de.telran.module_1.lesson_3.statics;

public class Cat {
    private String name = "Noname";
    private int age;
    // блок инициализации
    {
        age = 10;
    }

    static final int COUNT_LEGS = 4; // константа

    static private int countEars;

    // статический блок инициализации
    static {
        countEars = 2;
    }

    static int weigh; //только статические переменные

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
        weigh = this.age * 2; // при создании объекта это возможно
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", countEars=" + countEars +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static int getCountEars() {
        return countEars;
    }

    public static void setCountEars(int countEars) {
        Cat.countEars = countEars;
    }

    public static boolean isRunSpeed() { // работает только со статическими переменными и методами
        return (weigh * COUNT_LEGS  > 30) ? false : true;
    }
}
