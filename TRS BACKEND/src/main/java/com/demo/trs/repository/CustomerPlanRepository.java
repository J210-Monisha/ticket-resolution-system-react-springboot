package com.demo.trs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.trs.model.CustomerPlan;

public interface CustomerPlanRepository extends JpaRepository<CustomerPlan, Integer> {

}
