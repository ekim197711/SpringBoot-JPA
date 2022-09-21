package com.example.springbootjparelations.data.sharedkey;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shared/captain")
@RequiredArgsConstructor
public class SharedCaptainRestController {
    private final SharedCaptainRepository repository;

    @GetMapping("/")
    public List<SharedCaptain> all(){
        return repository.findAll();
    }
}
