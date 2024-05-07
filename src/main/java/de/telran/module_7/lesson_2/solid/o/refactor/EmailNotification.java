package de.telran.module_7.lesson_2.solid.o.refactor;

public class EmailNotification implements NotificationService{
    @Override
    public void sendMessage(String message) {
        System.out.println("Отправили по EMail ->"+message);
    }
}
