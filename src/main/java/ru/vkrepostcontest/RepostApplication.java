package ru.vkrepostcontest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class RepostApplication {

    public static void main(String[] args) {
        SpringApplication.run(RepostApplication.class, args);
    }
}
