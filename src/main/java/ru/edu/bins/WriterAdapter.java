package ru.edu.bins;

import org.springframework.stereotype.Component;

@Component
public class WriterAdapter{

    //@Override
    public String getMessage() {
        return "hello from WriterAdapter";
    }

    //@Override
    public void divideData(int a, int b) {
        if (b == 0) {
            throw new DivideException("divide by zero");
        }

        int c = a / b;
    }
}
