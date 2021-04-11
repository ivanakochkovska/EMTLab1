package com.example.librarybackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class EMTLab1Application {

    public static void main(String[] args) {
        SpringApplication.run(EMTLab1Application.class, args);
    }
}