package com.example.springbootjparelations.data.onetoone.standard;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StandardCaptain {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String bio;

    @OneToOne
    @JoinColumn(name = "ship_id", referencedColumnName = "id")
    private StandardSpaceShip ship;
}
