package com.example.springbootjparelations.data.onetoone.standard;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/standard/spaceship")
@RequiredArgsConstructor
public class StandardSpaceShipRestController {
    private final StandardSpaceShipRepository repository;

    @GetMapping("/")
    public List<StandardSpaceShip> all(){
        return repository.findAll();
    }
}
