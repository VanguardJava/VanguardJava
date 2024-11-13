package com.fdb.vanguard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fdb.vanguard.model.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long > {

}
