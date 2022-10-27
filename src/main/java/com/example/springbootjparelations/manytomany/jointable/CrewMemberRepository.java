package com.example.springbootjparelations.manytomany.jointable;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Optional;

public interface CrewMemberRepository extends JpaRepository<CrewMember, Integer> {
    Optional<CrewMember> findByName(@NonNull String name);

    @Query("select c from CrewMember c left join fetch c.skills")
    List<CrewMember> selectAllWithSkill();
}
