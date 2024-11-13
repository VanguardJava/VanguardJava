package com.fdb.vanguard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fdb.vanguard.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
