package de.telran.module_4.lesson_1;

public class MyException extends RuntimeException{
    public MyException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyException(String message) {
        super(message);
    }
}
