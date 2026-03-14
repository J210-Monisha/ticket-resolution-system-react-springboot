package com.demo.trs.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.demo.trs.model.Executive;
import com.demo.trs.service.ExecutiveService;

@RestController
@RequestMapping("/api/executive")
public class ExecutiveController {

    private final ExecutiveService executiveService;

    public ExecutiveController(ExecutiveService executiveService) {
        this.executiveService = executiveService;
    }

    @PostMapping("/add")
    public Executive addExecutive(@RequestBody Executive executive){
        return executiveService.addExecutive(executive);
    }

    @GetMapping("/all")
    public List<Executive> getAllExecutives(){
        return executiveService.getAllExecutives();
    }
}