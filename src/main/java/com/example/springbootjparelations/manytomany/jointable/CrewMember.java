package com.example.springbootjparelations.manytomany.jointable;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CrewMember {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "crew_id")
    private Integer crewId;
    private String name;
    @ManyToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JoinTable(name = "crew_member_skills",
            joinColumns = @JoinColumn(referencedColumnName = "crew_id"),
            inverseJoinColumns = @JoinColumn(referencedColumnName = "skill_id")
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Skill> skills;

}
