package com.project.developer.cpa.config;

import com.project.developer.cpa.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Initializer implements CommandLineRunner {

@Autowired
    private final CardRepository repository;

    public Initializer(CardRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {

System.out.println("ssssssssssssssssssssssssssssssssssssssssssssssss");
    }
}
