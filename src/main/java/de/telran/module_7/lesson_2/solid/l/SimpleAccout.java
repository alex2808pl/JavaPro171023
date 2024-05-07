package de.telran.module_7.lesson_2.solid.l;

import java.math.BigDecimal;
//Liskov substitution principle – принцип подстановки Барбары Лисков
//        (функции, которые используют базовый тип, должны иметь возможность
//        использовать подтипы базового типа, не зная об этом. Подклассы не
//        могут замещать поведения базовых классов. Подтипы должны дополнять базовые типы);

public class SimpleAccout {
    public static void main(String[] args) {
        Account account = new Account();
        System.out.println(account.balance("11111"));
        account.payment("1111",new BigDecimal(200));

        account = new SalaryAccount();
        account.payment("1111",new BigDecimal(200));

        account = new DepositAccount(); // сломалась функциональность предка
        account.payment("1111",new BigDecimal(200));
    }
}
