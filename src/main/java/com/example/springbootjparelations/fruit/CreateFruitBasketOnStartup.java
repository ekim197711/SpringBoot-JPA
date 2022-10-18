package com.example.springbootjparelations.fruit;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class CreateFruitBasketOnStartup {
    private final FruitBasketRepository fruitBasketRepository;
    private final DeliveryBikeRepository deliveryBikeRepository;

    @PostConstruct
    public void createSome(){
        DeliveryBike deliveryBike = deliveryBikeRepository.save(
                DeliveryBike
                        .builder()
                        .description("Red and fast")
                        .owner("Mike")
                        .build()
        );

        FruitBasket brown = fruitBasketRepository.save(
                FruitBasket.builder()
                        .color("Brown")
                        .maxWeight(100.0d)
                        .deliveryBike(deliveryBike)
                        .build()
        );
    }

}
