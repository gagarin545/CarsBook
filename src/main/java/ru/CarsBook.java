package ru;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarsBook {
    public static void main(String[] args) {
        SpringApplication.run(CarsBook.class, args).getBeanFactory();
    }
}
