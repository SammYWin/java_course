package com.labs;

import com.labs.models.User;
import com.labs.services.dbService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        //URL: http://localhost:8080/users_list
    }
}
