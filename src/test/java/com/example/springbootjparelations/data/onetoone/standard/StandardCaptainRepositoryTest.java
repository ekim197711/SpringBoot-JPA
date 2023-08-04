package com.example.springbootjparelations.data.onetoone.standard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class StandardCaptainRepositoryTest {

    @Autowired
    StandardCaptainRepository captainRepository;

    @Test
    void testStuff() {
        Optional<StandardCaptain> byId = captainRepository.findById(5L);
        Assertions.assertEquals("Mike", byId.orElseThrow().getName());
        Assertions.assertEquals("Pyramid", byId.orElseThrow().getShip().getDescription());
    }
}