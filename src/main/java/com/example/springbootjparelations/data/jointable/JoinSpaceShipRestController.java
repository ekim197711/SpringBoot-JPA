package com.example.springbootjparelations.data.jointable;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/joined/spaceship")
@RequiredArgsConstructor
@Slf4j
public class JoinSpaceShipRestController {
    private final JoinSpaceShipRepository repository;

    @GetMapping("/")
    public List<JoinSpaceShip> all(){
        repository.findAll().forEach(s -> log.info(s + ", " + s.getCaptain()));
        return repository.findAll();
    }
}
