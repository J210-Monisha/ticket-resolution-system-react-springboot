package com.demo.trs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.trs.model.Plan;
import com.demo.trs.service.PlanService;

@RestController
@RequestMapping("/api/plan")
public class PlanController {
	
	@Autowired
	private PlanService planService;
	
	@PostMapping("/add")
	public Plan add(@RequestBody Plan plan) {
		return planService.add(plan);
	}

}
