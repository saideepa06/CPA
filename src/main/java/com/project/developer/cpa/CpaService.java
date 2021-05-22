package com.project.developer.cpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class CpaService {

    public static void main(String[] args) {
        SpringApplication.run(CpaService.class, args);
    }
}

