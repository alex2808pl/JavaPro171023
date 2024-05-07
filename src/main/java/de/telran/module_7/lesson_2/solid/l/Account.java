package de.telran.module_7.lesson_2.solid.l;

import java.math.BigDecimal;

//Liskov substitution principle – принцип подстановки Барбары Лисков
//        (функции, которые используют базовый тип, должны иметь возможность
//        использовать подтипы базового типа, не зная об этом. Подклассы не
//        могут замещать поведения базовых классов. Подтипы должны дополнять базовые типы);

public class Account {

    // остаток по счету
    public BigDecimal balance(String numberAccount){
        //logic
        BigDecimal bigDecimal = new BigDecimal(1000);
        return bigDecimal;
    };

    // пополнение счета
    public void refill(String numberAccount, BigDecimal sum){
        //logic
    }

    // опалата со счета
    public void payment(String numberAccount, BigDecimal sum){
        //logic
        System.out.println("Оплачиваем со счета "+numberAccount+" сумму "+sum);
    }
}
