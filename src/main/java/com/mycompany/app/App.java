package com.mycompany.app;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 */
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(App.class);

        app.setDefaultProperties(
            Collections.singletonMap(
                // Set your default properties here
                "server.port", "3000"
            )
        );

        app.run(args);
    }
}
