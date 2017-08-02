package com.haipeng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
//        SpringApplication.run(MobileUploadController.class, args);
//        SpringApplication.run(MainController.class, args);
    }

}