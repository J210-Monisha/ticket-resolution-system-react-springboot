package com.demo.trs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.trs.model.User;

import java.util.Optional;

@Repository
public interface AuthRepository extends JpaRepository<User,Integer> {
    Optional<User> findByUsername(String username);
}