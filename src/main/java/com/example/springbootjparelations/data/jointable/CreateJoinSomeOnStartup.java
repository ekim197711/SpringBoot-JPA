package com.example.springbootjparelations.data.jointable;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
@Slf4j
public class CreateJoinSomeOnStartup {
    private final JoinSpaceShipRepository spaceShipRepository;
    private final JoinCaptainRepository captainRepository;

    @PostConstruct
    public void createEntities(){
        JoinSpaceShip pyramid = spaceShipRepository.save(
                JoinSpaceShip.builder()
                .description("Pyramid")
                .fuel(55)
                .maxSpeed(22d)
                .build());
        spaceShipRepository.save(pyramid);
        JoinCaptain joinCaptain = JoinCaptain.builder()
                .name("Brian")
                .bio("Smart guy")
                .build();
        JoinCaptain savedCaptain = captainRepository.save(joinCaptain);
        savedCaptain.setShip(pyramid);
        captainRepository.save(joinCaptain);
        log.info("Done creating default rows");
    }

    @EventListener(value = ApplicationStartedEvent.class)
    public void createAnother(){
        log.info("App started event...");
        JoinSpaceShip box = spaceShipRepository.save(
                JoinSpaceShip.builder()
                        .description("Box")
                        .fuel(44)
                        .maxSpeed(11d)
                        .build());
        spaceShipRepository.save(box);
        JoinCaptain joinCaptain = JoinCaptain.builder()
                .name("Poul")
                .bio("Eager and happy")
                .build();
        JoinCaptain savedCaptain = captainRepository.save(joinCaptain);
        savedCaptain.setShip(box);
        captainRepository.save(savedCaptain);

        log.info("Done creating default rows");
    }
}
