package com.demo.trs.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.demo.trs.model.Customer;
import com.demo.trs.model.User;
import com.demo.trs.repository.AuthRepository;
import com.demo.trs.repository.CustomerRepository;

@Service
public class AuthService {

    private final AuthRepository authRepository;
    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(AuthRepository authRepository,
                       CustomerRepository customerRepository,
                       PasswordEncoder passwordEncoder) {
        this.authRepository = authRepository;
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User signUp(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User savedUser = authRepository.save(user);

        if(user.getRole().equalsIgnoreCase("CUSTOMER")) {
            Customer customer = new Customer();
            customer.setName(user.getUsername());
            customer.setCity("Unknown");
            customerRepository.save(customer);
        }

        return savedUser;
    }

    public User authenticate(String username, String rawPassword) {
        return authRepository.findByUsername(username)
                .filter(user -> passwordEncoder.matches(rawPassword, user.getPassword()))
                .orElse(null);
    }
}