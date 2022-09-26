package com.example.springbootjparelations.manytomany.jointable;


import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Integer> {
}
