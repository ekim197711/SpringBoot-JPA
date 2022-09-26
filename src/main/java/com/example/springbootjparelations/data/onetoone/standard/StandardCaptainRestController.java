package com.example.springbootjparelations.data.onetoone.standard;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/standard/captain")
@RequiredArgsConstructor
public class StandardCaptainRestController {
    private final StandardCaptainRepository repository;

    @GetMapping("/")
    public List<StandardCaptain> all(){
        return repository.findAll();
    }
}
