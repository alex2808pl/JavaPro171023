package de.telran.module_7.lesson_2.solid.s.refactor;

public class NotificationService {
    public void sendMessage(String typeMessage, String message) { //отправка сообщения
        if (typeMessage.equals("email")) {
            //write email
            //use JavaMailSenderAPI
        }
    }
}
