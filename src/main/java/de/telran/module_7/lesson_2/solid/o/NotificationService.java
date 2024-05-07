package de.telran.module_7.lesson_2.solid.o;
//Open/closed principle – принцип открытости/закрытости
//        (программные сущности должны быть закрыты для изменения,
//        но открыты для расширения);
public class NotificationService {
    public void sendMessage(String typeMessage, String message) { //отправка сообщения
        if (typeMessage.equals("email")) {
            //write email
            //use JavaMailSenderAPI
        }
        if (typeMessage.equals("sms")) { // пришлось править уже существующий код класса
            //write email
            //use JavaMailSenderAPI
        }
    }
}
