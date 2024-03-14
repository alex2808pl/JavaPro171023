package de.telran.module_4.lesson_1;

public class SimpleException {

    public static void main(String[] args) throws InterruptedException {

        int result = div(10,0);
        if(result!=Integer.MAX_VALUE) {
            System.out.println(result);
        }
        else {
            System.out.println("Error div");
        }

       result = divException(10,0);
        System.out.println(result);

        try {
            result = divNoCatchError(10, 0);
        }
        catch (ArithmeticException ex){
            System.out.println(ex.getMessage());
            result = divNoCatchError(10, 1);
        }
        System.out.println(result);

        try {
            result = div(10,0);
        }
        catch (RuntimeException e) {
            System.out.println(e.getCause().getMessage()); // вывод информации о предке
        }


        // Пользовательский Exception
        result = divUserException(10, 2);

        try {
            result = divUserException(10, 0);
        }
        catch (MyException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            result = divExceptionUserCause(10, 0);
        }
        catch (MyException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getCause().getMessage());
        }


        System.out.println("--- Конец программы ----");

    }

    static int div(int arg1, int arg2) {
        if(arg2==0) {
           return Integer.MAX_VALUE;
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) { // InterruptedException - отслеживаемое исключение
            throw new RuntimeException(e); // RuntimeException - не отслеживамое
        }
        return arg1 / arg2;
    }

    static int divException(int arg1, int arg2) {
        try {
            return arg1 / arg2;
        }
        catch (ArithmeticException ex) {
            System.out.println(ex.getMessage());
            return Integer.MAX_VALUE;
        }
    }

    static int divNoCatchError(int arg1, int arg2) throws InterruptedException {

            Thread.sleep(1000);

        return arg1 / arg2;
    }

    static int divUserException(int arg1, int arg2) {
        if(arg2==0) {
             throw new MyException("Второй аргумент  не может быть 0");
        }
      return arg1 / arg2;
    }

    static int divExceptionUserCause(int arg1, int arg2) {
        try {
            return arg1 / arg2;
        }
        catch (ArithmeticException ex) {
            throw new MyException("Не 0", ex);
        }
    }

}
