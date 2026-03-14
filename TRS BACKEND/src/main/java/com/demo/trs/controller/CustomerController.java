package com.demo.trs.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.demo.trs.model.Customer;
import com.demo.trs.service.CustomerService;
@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/add")
    public Customer postCustomer(@RequestBody Customer customer) {
        return customerService.add(customer);
    }

    @GetMapping("/info/{userId}")
    public Customer getCustomerInfo(@PathVariable int userId) {
        return customerService.getById(userId);
    }

    @GetMapping("/all")
    public List<Customer> getAllCustomers() {
        return customerService.getAll();
    }
}