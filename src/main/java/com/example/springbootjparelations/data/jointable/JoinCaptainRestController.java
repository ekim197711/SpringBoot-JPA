package com.example.springbootjparelations.data.jointable;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/joined/captain")
@RequiredArgsConstructor
public class JoinCaptainRestController {
    private final JoinCaptainRepository repository;

    @GetMapping("/")
    public List<JoinCaptain> all(){
        return repository.findAll();
    }
}
