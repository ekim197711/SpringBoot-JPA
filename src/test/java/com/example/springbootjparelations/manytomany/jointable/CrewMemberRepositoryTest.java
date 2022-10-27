package com.example.springbootjparelations.manytomany.jointable;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CrewMemberRepositoryTest {
    @Autowired
    CrewMemberRepository crewMemberRepository;
    @Autowired
    SkillRepository skillRepository;

    @Test
    void addMembers() {
        System.out.println(String.format("Skills in db: %s and crew in db: %s"
                , skillRepository.count()
                , crewMemberRepository.count()
        ));
        crewMemberRepository.deleteAll();
//        skillRepository.deleteAll();

        Assertions.assertEquals(0, skillRepository.count());
        Assertions.assertEquals(0, crewMemberRepository.count());

        List<Skill> skills = skillRepository.saveAll(
                List.of(
                        Skill.builder()
                                .description("Cooking").build(),
                        Skill.builder()
                                .description("Fishing").build()
                )
        );

        Skill skill = skillRepository.findAll().get(0);

        CrewMember mike = crewMemberRepository.save(
                CrewMember
                        .builder()
                        .name("Mike")
                        .build()
        );
        mike.setSkills(List.of(skill));
        crewMemberRepository.save(mike);
//        skill.setCrewMembers(List.of(mike));
//        skillRepository.save(skill);
        Assertions.assertEquals(1, crewMemberRepository.count());
        Assertions.assertEquals(2, skillRepository.count());

        skillRepository.findAll().forEach(System.out::println);
        System.out.println("Skills on Mike:");
        crewMemberRepository.findAll().forEach(c -> c.getSkills().forEach(System.out::println));
        Assertions.assertEquals(1, crewMemberRepository.selectAllWithSkill().get(0).getSkills().size());

    }
}