package com.demo.trs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.trs.model.Customer;
import com.demo.trs.repository.CustomerRepository;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // Add a new customer
    public Customer add(Customer customer) {
        return customerRepository.save(customer);
    }

    // Get customer by username (used for logged-in user)
    public Customer getByUsername(String username) {
        return customerRepository.findByName(username)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    // Get customer by ID (used when adding tickets)
    public Customer getById(int id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    // Get all customers (if needed, e.g., admin view)
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }
}