package de.telran.module_6.lesson_3.synchronize;

import java.util.Arrays;

public class SimpleBankSynchronized {
    public static final int NACCOUNTS = 100; //количество счетов
    public static final double INITIAL_BALANCE = 1000; //начальный баланс каждого счета
    public static final double MAX_AMOUNT = 1000; //максимальная сумма
    public static final int DELAY = 10;

    public static void main(String[] args) {
        var bank = new Bank(NACCOUNTS, INITIAL_BALANCE);
        for (int i = 0; i < NACCOUNTS; i++) {
            int fromAccount = i;
            Runnable r = () ->
            {
                try {
                    while (true) {
                        int toAccount = (int) (bank.size() * Math.random());
                        double amount = MAX_AMOUNT * Math.random();
                        bank.transfer(fromAccount, toAccount, amount);
                        Thread.sleep((int) (DELAY * Math.random()));
                    }
                } catch (InterruptedException e) {
                }
            };
            var t = new Thread(r);
            t.start();
        }
    }
}

class Bank
{
    private final double[] accounts;
    Object obj1 = new Object();
    Object obj2 = new Object();

    /**
     * Конструктор.
     * @param n — количество счетов
     * @param initialBalance — изначальный баланс на каждом счете
     */

    public Bank(int n, double initialBalance)
    {
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
    }

    /**
     * Осуществляет переводы средств с одного счета на другой.
     * @param from — счет, с которого осуществляется перевод
     * @param to — счет, куда осуществляется перевод
     * @param amount — сумма для перевода
     */

    public /*synchronized*/ void transfer(int from, int to, double amount)
    {
        if (accounts[from] < amount) return; // денег не хватает
        System.out.print(Thread.currentThread());
//        synchronized (this) { //блок синхронизации с монитором this
        synchronized (obj1) { //блок синхронизации c внешним монитором
            accounts[from] -= amount;
            System.out.printf(" %10.2f from %d to %d", amount, from, to);
            accounts[to] += amount;
            System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
        }
    }

    public /*synchronized*/ void transfer1(int from, int to, double amount)
    {
        if (accounts[from] < amount) return; // денег не хватает
        System.out.print(Thread.currentThread());
        synchronized (obj2) { //блок синхронизации
            accounts[from] -= amount;
            System.out.printf(" %10.2f from %d to %d", amount, from, to);
            accounts[to] += amount;
            System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
        }
    }

    /**
     * Считает сумму остатков на всех счетах.
     * @return общий баланс
     */

    public double getTotalBalance()
    {
        double sum = 0;
        for (double a : accounts)
            sum += a;
        return sum;
    }
    /**
     * Возвращает количества счетов в банке.
     * @return количество счетов
     */
    public int size()
    {
        return accounts.length;
    }
}
