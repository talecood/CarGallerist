package com.goktug.cargallerist.repository;

import com.goktug.cargallerist.model.SaledCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaledCarRepository extends JpaRepository<SaledCar,Long> {
}
