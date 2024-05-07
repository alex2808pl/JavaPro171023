package de.telran.module_7.lesson_2.solid.i;
//Interface segregation principle – принцип разделения интерфейса
//        (много специализированных интерфейсов лучше, чем один универсальный);

public interface Payments {
    void payWebMoney();
    void payCreditCard();
    void payPhoneNumber();
}
