package com.example.springbootjparelations.data.standard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.util.Assert;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@ActiveProfiles("default")
class SharedCaptainRestControllerTest {

    @Autowired
    StandardCaptainRestController restController;

    @Test
    void all() {
        List<StandardCaptain> all = restController.all();
        Assertions.assertTrue( all.size() > 0);
        Assertions.assertNotNull(all.get(0).getShip());
        Assertions.assertNotNull(all.get(0).getShip().getDescription());
        all.forEach(System.out::println);
    }
}