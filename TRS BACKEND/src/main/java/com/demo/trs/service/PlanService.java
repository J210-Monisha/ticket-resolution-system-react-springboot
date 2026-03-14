package com.demo.trs.service;

import org.springframework.stereotype.Service;

import com.demo.trs.model.Plan;
import com.demo.trs.repository.PlanRepository;

@Service
public class PlanService {
	private final PlanRepository planRepository;

	public PlanService(PlanRepository planRepository) {
		this.planRepository = planRepository;
	}
	
	public Plan add(Plan plan) {
		return planRepository.save(plan);
	}
	
	public Plan getById(int planId) {
        return planRepository
                .findById(planId)
                .orElseThrow(()-> new RuntimeException("Plan Id is not valid"));

}
}