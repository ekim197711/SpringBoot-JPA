package com.example.springbootjparelations.onetomany.jointable;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JoinCargoShipPopulator {

    private final JoinCargoShipRepository joinCargoShipRepository;
    private final JoinCargoRepository joinCargoRepository;

    @PostConstruct
    public void createCargoShips(){
        JoinCargoShip round = joinCargoShipRepository.save(
                JoinCargoShip.builder()
                        .description("Round")
                        .build()
        );

        joinCargoRepository.saveAll(
                List.of(
                        JoinCargo.builder().cargoship(round).cargoType("Fruit").build(),
                        JoinCargo.builder().cargoship(round).cargoType("Minerals").build(),
                        JoinCargo.builder().cargoship(round).cargoType("Rare metals").build(),
                        JoinCargo.builder().cargoship(round).cargoType("Computer").build()
                )
        );


    }
}
