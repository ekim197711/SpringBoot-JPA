package com.example.springbootjparelations.data.sharedkey;

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
public class SharedCaptain {
    @Id
    @Column(name="captain_id")
    private Long id;
    private String name;
    private String bio;

    @OneToOne
    @MapsId
    @JoinColumn(name = "captain_id")
    private SharedSpaceShip ship;
}
