package com.goktug.cargallerist.repository;

import com.goktug.cargallerist.model.GalleristCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GalleristCarRepository extends JpaRepository<GalleristCar,Long> {
}
