package com.demo.trs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.trs.model.Executive;
import com.demo.trs.repository.ExecutiveRepository;

@Service
public class ExecutiveService {

    private final ExecutiveRepository executiveRepository;

    public ExecutiveService(ExecutiveRepository executiveRepository) {
        this.executiveRepository = executiveRepository;
    }

    public Executive addExecutive(Executive executive){
        return executiveRepository.save(executive);
    }

    public List<Executive> getAllExecutives(){
        return executiveRepository.findAll();
    }
}
