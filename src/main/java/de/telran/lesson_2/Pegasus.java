package de.telran.lesson_2;

public class Pegasus extends Horse {
    int countWings;

    public Pegasus() {
    }

    public Pegasus(String name, int weight, String color, int countWings) {
        this.countWings = countWings;
        this.name = name;
        this.weight = weight;
        this.color = color;
    }

    public Pegasus(String name, int countHorseShoe, int weight, String color, int countWings) {
        super(name, countHorseShoe, weight, color); // как инициализировать приватную переменную предка
        this.countWings = countWings;
    }

    public void fly() {
        System.out.println(name + " c весом "+weight+" летит на "+countWings+" крыльях");
    }

    @Override
    void transports(int weight)  {
        System.out.println("Пегас по имени "+name + " везет груз "+weight + " на подвесе.");
    }

    //переопределенный метод
    void transports(double weight)  {
        System.out.println("Пегас по имени "+name + " везет груз неизвестного веса на подвесе.");
    }

    //перегруженный метод
    @Override
    public void run() {
        super.run();
        System.out.println("Новая функция");
    }
}
