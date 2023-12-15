package ru.edu;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.edu.bins.DivideException;
import ru.edu.bins.Writer;
import ru.edu.bins.WriterAdapter;

@SpringBootApplication
public class Application implements CommandLineRunner {
//public class Application {

    private final WriterAdapter writerAdapter;

    public Application(WriterAdapter writerAdapter) {
        this.writerAdapter = writerAdapter;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String text = writerAdapter.getMessage();

        System.out.println(text);

        System.out.println("-----------");
        writerAdapter.divideData(20, 5);

        System.out.println("------------");
        try {
            writerAdapter.divideData(20, 0);
        } catch (DivideException ex) {
            System.out.println("divide error occurred");
        }

    }
}
