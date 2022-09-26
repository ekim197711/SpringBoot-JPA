package com.example.springbootjparelations.data.onetoone.sharedkey;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shared/spaceship")
@RequiredArgsConstructor
@Slf4j
public class SharedSpaceShipRestController {
    private final SharedSpaceShipRepository repository;

    @GetMapping("/")
    public List<SharedSpaceShip> all(){
        repository.findAll().forEach(s -> log.info(s + ", " + s.getCaptain()));
        return repository.findAll();
    }
}
