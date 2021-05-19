package com.project.developer.cpa.config;

import com.project.developer.cpa.repository.CardRepository;
import org.springframework.boot.CommandLineRunner;

public class Initializer implements CommandLineRunner {


    private final CardRepository repository;

    public Initializer(CardRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {


    }
}
