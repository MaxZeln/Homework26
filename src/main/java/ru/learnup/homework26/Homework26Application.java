package ru.learnup.homework26;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.learnup.homework26.dao.*;
import ru.learnup.homework26.service.BookWarehouseService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
@Slf4j
public class Homework26Application {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(Homework26Application.class, args);
        BookWarehouseService service1 = context.getBean(BookWarehouseService.class);
        BookWarehouseService service2 = context.getBean(BookWarehouseService.class);

        ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        pool.submit(new Runnable() {
            @Override
            public void run() {
                service1.transactionBuyABook(2);
            }
        });

        pool.submit(new Runnable() {
            @Override
            public void run() {
                service2.transactionBuyABook(2);
            }
        });

        pool.shutdown();

//        new Thread(() -> service.transactionBuyABook(2)).start();
//        new Thread(() -> service.transactionBuyABook(2)).start();

    }
}
