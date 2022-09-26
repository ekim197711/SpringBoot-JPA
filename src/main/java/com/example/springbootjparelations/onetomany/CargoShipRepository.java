package com.example.springbootjparelations.onetomany;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CargoShipRepository extends JpaRepository<CargoShip, Integer> {
}
