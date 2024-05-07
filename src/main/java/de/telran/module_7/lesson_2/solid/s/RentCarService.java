package de.telran.module_7.lesson_2.solid.s;
//Single responsibility principle – принцип единственной обязанности
//        на каждый класс должна быть возложена одна-единственная обязанность.
//        Класс должен быть ответственен лишь за что-то одно.

public class RentCarService {
    public Car findCar(String carNo) { // поиск авто
        //find car by number
        Car car = new Car();
        return car;
    }

    public Order orderCar(String carNo, Client client) {  // создание заказа на авто
        //client order car
        Order order = new Order();
        return order;
    }

    public void printOrder(Order order) { //печать заказа
        //print order
    }
    public void getCarInterestInfo(String carType) { // поиск по желанию
        if (carType.equals("sedan")) {
            //do some job
        }
        if (carType.equals("pickup")) {
            //do some job
        }
        if (carType.equals("van")) {
            //do some job
        }
    }
    public void sendMessage(String typeMessage, String message) { //отправка сообщения
        if (typeMessage.equals("email")) {
            //write email
            //use JavaMailSenderAPI
        }
    }
}

