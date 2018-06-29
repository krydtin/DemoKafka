package com.krydtin.demo;

import com.krydtin.demo.services.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Autowired
    private ProducerService producerService;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 10; i++) {
            producerService.send();
            Thread.sleep(1000);
        }
    }

}
