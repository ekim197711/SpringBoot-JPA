package com.example.springbootjparelations.data.sharedkey;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
@Slf4j
public class CreateSharedSomeOnStartup {
    private final SharedSpaceShipRepository spaceShipRepository;
    private final SharedCaptainRepository captainRepository;

    @PostConstruct
    public void createEntities(){
        SharedSpaceShip pyramid = spaceShipRepository.save(
                SharedSpaceShip.builder()
                .description("Pyramid")
                .fuel(55)
                .maxSpeed(22d)
                .build());

        log.info("Share ship: {}",pyramid);
        pyramid.setCaptain(SharedCaptain.builder()
                .name("Brian")
                .bio("Smart guy")
                        .ship(pyramid)
                .build());
        spaceShipRepository.save(pyramid);

        log.info("Done creating default rows");
    }
}
