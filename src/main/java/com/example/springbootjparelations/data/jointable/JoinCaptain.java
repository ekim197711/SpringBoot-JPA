package com.example.springbootjparelations.data.jointable;

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
public class JoinCaptain {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String bio;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "captain_space_ship",
            joinColumns =
                    { @JoinColumn(name = "captain_id", referencedColumnName = "id") },
            inverseJoinColumns =
                    { @JoinColumn(name = "space_ship_id", referencedColumnName = "id") })
    private JoinSpaceShip ship;
}
