package com.example.springbootjparelations.fruit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "fruit_basket")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FruitBasket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String color;
    private Double maxWeight;
    @OneToOne
    @JoinColumn(name = "delivery_bike_id")
    private DeliveryBike deliveryBike;

}
