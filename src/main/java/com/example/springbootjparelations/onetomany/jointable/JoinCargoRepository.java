package com.example.springbootjparelations.onetomany.jointable;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JoinCargoRepository extends JpaRepository<JoinCargo, Integer> {
}
