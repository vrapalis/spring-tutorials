package com.example.application;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Application test.
 */
@SpringBootTest
class ApplicationTests {

    @Test
    void contextLoads() {
        Assertions.assertThat("Greeting").isEqualTo("Greeting");
    }

}
