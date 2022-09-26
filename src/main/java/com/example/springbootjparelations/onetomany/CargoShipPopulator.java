package com.example.springbootjparelations.onetomany;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CargoShipPopulator {

    private final CargoShipRepository cargoShipRepository;
    private final CargoRepository cargoRepository;

    @PostConstruct
    public void createCargoShips(){
        CargoShip round = cargoShipRepository.save(
                CargoShip.builder()
                        .description("Round")
                        .build()
        );

        cargoRepository.saveAll(
                List.of(
                        Cargo.builder().cargoship(round).cargoType("Fruit").build(),
                        Cargo.builder().cargoship(round).cargoType("Minerals").build(),
                        Cargo.builder().cargoship(round).cargoType("Rare metals").build(),
                        Cargo.builder().cargoship(round).cargoType("Computer").build()
                )
        );


    }
}
