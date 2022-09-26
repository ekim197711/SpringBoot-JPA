package com.example.springbootjparelations.manytomany.jointable;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CreateSomeCrewOnStart {
    private final CrewMemberRepository crewMemberRepository;
    private final SkillRepository skillRepository;

    @PostConstruct
    public void createSome(){
        Skill math = skillRepository.save(Skill
                .builder()
                .description("Math")
                .build());
        Skill flying = skillRepository.save(Skill
                .builder()
                .description("Flying")
                .build());
        Skill dodging = skillRepository.save(Skill
                .builder()
                .description("Avoid Asteroids")
                .build());
        CrewMember mike = crewMemberRepository.save(
                CrewMember.builder().name("Mike").skills(List.of(math,flying)).build()
        );
        CrewMember jane = crewMemberRepository.save(
                CrewMember.builder().name("Jane").skills(List.of(math,flying,dodging)).build()
        );
        CrewMember line = crewMemberRepository.save(
                CrewMember.builder().name("Line").skills(List.of(flying)).build()
        );
    }
}
