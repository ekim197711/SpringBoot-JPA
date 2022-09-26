package com.example.springbootjparelations.data.onetoone.sharedkey;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SharedCaptainRepository extends JpaRepository<SharedCaptain, Long> {
}
