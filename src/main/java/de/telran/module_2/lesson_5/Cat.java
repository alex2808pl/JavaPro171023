package de.telran.module_2.lesson_5;

public class Cat implements Comparable<Cat>{
    private String name;
    private int age;

    public String talk() {
        return "Meow";
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cat cat = (Cat) o;

        if (age != cat.age) return false;
        return name.equals(cat.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Cat o) {
        if(this.age == o.age) //сравнение 1-го уровня
            return this.name.compareTo(o.name); // сравнение 2-го уровня
        if(this.age < o.age) return -1;
        else return 1;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
