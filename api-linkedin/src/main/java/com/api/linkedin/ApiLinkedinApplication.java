package com.api.linkedin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ApiLinkedinApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiLinkedinApplication.class, args);
    }

}
