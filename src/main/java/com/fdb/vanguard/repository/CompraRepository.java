package com.fdb.vanguard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fdb.vanguard.model.Compra;

@Repository
public interface CompraRepository extends JpaRepository <Compra, Long> {

}
