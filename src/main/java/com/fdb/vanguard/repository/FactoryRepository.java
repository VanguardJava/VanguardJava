package com.fdb.vanguard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fdb.vanguard.model.Factory;

@Repository
public interface FactoryRepository extends JpaRepository <Factory, Long> {

}
