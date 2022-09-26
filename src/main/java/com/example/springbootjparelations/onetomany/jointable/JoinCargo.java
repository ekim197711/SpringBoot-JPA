package com.example.springbootjparelations.onetomany.jointable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class JoinCargo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String cargoType;
    @ManyToOne
    @JoinTable(name = "joincargo_joincargoship",
            joinColumns = @JoinColumn(name = "cargo_id"), inverseJoinColumns = @JoinColumn(name = "cargo_ship_id"))
    private JoinCargoShip cargoship;
}
