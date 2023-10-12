package com.example.demo.testcontainerdatajpatest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test-container-flyway")
class TestcontainerDataJpaTestApplicationTests {

    @Test
    void contextLoads() {
    }

}
