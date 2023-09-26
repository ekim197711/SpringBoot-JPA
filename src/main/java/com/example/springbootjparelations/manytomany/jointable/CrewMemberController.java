package com.example.springbootjparelations.manytomany.jointable;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/manytomany/crewmember")
@RequiredArgsConstructor
public class CrewMemberController {
    private final CrewMemberRepository crewMemberRepository;

    @GetMapping("/{name}")
    public String deleteCrew(@PathVariable("name") String name) {
        Optional<CrewMember> byName = crewMemberRepository.findByName(name);
        crewMemberRepository.delete(byName.orElseThrow());
        return "done deleting " + byName.orElseThrow();
    }
}
