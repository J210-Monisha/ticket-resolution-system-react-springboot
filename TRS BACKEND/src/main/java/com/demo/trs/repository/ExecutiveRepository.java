package com.demo.trs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.demo.trs.model.Executive;

public interface ExecutiveRepository extends JpaRepository<Executive, Integer> {

}