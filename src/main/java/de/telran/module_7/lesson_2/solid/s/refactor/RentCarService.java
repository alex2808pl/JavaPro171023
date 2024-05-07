package de.telran.module_7.lesson_2.solid.s.refactor;

import de.telran.module_7.lesson_2.solid.s.Client;
import de.telran.module_7.lesson_2.solid.s.Order;

public class RentCarService {
    public Order orderCar(String carNo, Client client) {  // создание заказа на авто
        //client order car
        Order order = new Order();
        return order;
    }
}
