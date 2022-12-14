package com.example.springbootjparelations.data.onetoone.jointable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JoinSpaceShip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    private Integer fuel;
    private Double maxSpeed;
    @JsonIgnore
    @ToString.Exclude
    @OneToOne(mappedBy = "ship")
    private JoinCaptain captain;
}
