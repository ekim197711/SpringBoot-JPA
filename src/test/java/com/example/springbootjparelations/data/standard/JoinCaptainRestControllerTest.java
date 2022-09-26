package com.example.springbootjparelations.data.standard;

import com.example.springbootjparelations.data.onetoone.standard.StandardCaptain;
import com.example.springbootjparelations.data.onetoone.standard.StandardCaptainRestController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
//@ActiveProfiles("default")
class JoinCaptainRestControllerTest {

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