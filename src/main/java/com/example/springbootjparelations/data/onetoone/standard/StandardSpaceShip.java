package com.example.springbootjparelations.data.onetoone.standard;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StandardSpaceShip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    private Integer fuel;
    private Double maxSpeed;
    @JsonIgnore
    @ToString.Exclude
    @OneToOne(mappedBy = "ship")
    private StandardCaptain captain;
}
