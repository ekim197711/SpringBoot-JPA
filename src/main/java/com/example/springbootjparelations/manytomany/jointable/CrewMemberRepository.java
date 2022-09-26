package com.example.springbootjparelations.manytomany.jointable;


import org.springframework.data.jpa.repository.JpaRepository;

public interface CrewMemberRepository extends JpaRepository<CrewMember, Integer> {
}
