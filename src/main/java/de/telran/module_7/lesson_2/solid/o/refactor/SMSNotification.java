package de.telran.module_7.lesson_2.solid.o.refactor;

public class SMSNotification implements NotificationService{
    @Override
    public void sendMessage(String message) {
        System.out.println("Отправили по SMS ->"+message);
    }
}
