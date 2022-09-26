package com.example.springbootjparelations.data.onetoone.standard;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
@Slf4j
public class CreateSomeOnStartup {
    private final StandardSpaceShipRepository spaceShipRepository;
    private final StandardCaptainRepository captainRepository;

    @PostConstruct
    public void createEntities(){
        StandardSpaceShip pyramid = spaceShipRepository.save(
                StandardSpaceShip.builder()
                .description("Pyramid")
                .fuel(99)
                .maxSpeed(88.88d)
                .build());

        captainRepository.save(
                StandardCaptain.builder()
                        .name("Mike")
                        .bio("Nice guy")
                        .ship(pyramid)
                        .build()
        );
        log.info("Done creating default rows");
    }
}
