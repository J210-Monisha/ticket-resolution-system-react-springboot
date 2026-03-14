package com.demo.trs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.trs.model.Plan;

public interface PlanRepository extends JpaRepository<Plan,Integer> {

}
