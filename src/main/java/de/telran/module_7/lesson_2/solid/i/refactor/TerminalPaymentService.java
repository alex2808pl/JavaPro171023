package de.telran.module_7.lesson_2.solid.i.refactor;

public class TerminalPaymentService implements CreditCardPayment, PhoneNumberPayment{
    @Override
    public void payCreditCard() {
        //logic
    }
    @Override
    public void payPhoneNumber() {
        //logic
    }
}
