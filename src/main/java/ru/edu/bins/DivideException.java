package ru.edu.bins;

public class DivideException extends RuntimeException{

    public DivideException(String message) {
        super(message);
    }

    public DivideException(String message, Throwable cause) {
        super(message, cause);
    }

    public DivideException(Throwable cause) {
        super(cause);
    }
}
