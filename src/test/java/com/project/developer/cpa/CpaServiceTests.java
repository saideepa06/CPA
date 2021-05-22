package com.project.developer.cpa;

import org.junit.jupiter.api.Test;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = CpaService.class)
@TestPropertySource({"classpath:application.properties"})
@EnableConfigurationProperties
class CpaServiceTests {

    @Test
    void contextLoads() {
    }
}
