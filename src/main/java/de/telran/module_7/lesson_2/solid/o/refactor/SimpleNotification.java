package de.telran.module_7.lesson_2.solid.o.refactor;

public class SimpleNotification {
    public static void main(String[] args) {
        NotificationService message = new SMSNotification();
        message.sendMessage("Заберите товар!");

        message = new EmailNotification();
        message.sendMessage("Заберите товар!");
    }
}
