package com.example.springbootjparelations.fruit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryBike {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String description;
    private String owner;
    @OneToOne(mappedBy = "deliveryBike")
    private FruitBasket basket;
}
