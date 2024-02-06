package de.telran.module_1.lesson_1;

public class SimpleTaxi {
    public static void main(String[] args) {

            // static
            Car.isEngine = false;
            System.out.println(Car.isEngine);

            Car car1 = new Car();
            car1.name = "BMW";
            car1.weight = 10;
            car1.color = "красный";
            car1.setCountPassenger(3);
            car1.run();
            car1.transport();

            Car car2 = new Car("Audi", 8, "зеленый");
            car2.setCountPassenger(-2);
            car2.run();
            car2.transport();




    }
}


