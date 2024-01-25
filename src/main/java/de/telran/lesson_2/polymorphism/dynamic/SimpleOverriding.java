package de.telran.lesson_2.polymorphism.dynamic;

public class SimpleOverriding {
    public static void main(String[] args) {
        Dancer.loveApplause();
        System.out.println("Оплата віхода на сцену = "+Dancer.salary);

        Dancer dan1 = new Dancer("Вася", 20);

        Dancer danActor = dan1;
        danActor.dance();


        danActor = new BallDancer("Валя", 18);
        danActor.dance();

        danActor = new FolkDance("Гриша", 30);
        danActor.dance();

        danActor = new BreakDancer("Мирон", 40);
        danActor.dance();
        BreakDancer.loveApplause();
        System.out.println("Оплата віхода на сцену = "+BreakDancer.salary);

        danActor = dan1;
        danActor.dance();

        BallDancer ballDancer = new BallDancer("Толя", 45);
        ballDancer.dance();
        ballDancer.dance("пасадобль");





    }
}
