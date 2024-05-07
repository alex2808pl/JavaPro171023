package de.telran.module_7.lesson_2.solid.l.refactor;

import java.math.BigDecimal;

public class SalaryAccount extends PaymentAccount {
    @Override
    public BigDecimal balance(String numberAccount){
        //logic
        return new BigDecimal(1000);
    };
    @Override
    public void refill(String numberAccount, BigDecimal sum){
        //logic
    }
    @Override
    public void payment(String numberAccount, BigDecimal sum){
        //logic
    }
}