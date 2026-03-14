package com.demo.trs.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.demo.trs.model.User;
import com.demo.trs.service.AuthService;

import java.util.HashMap;
import java.util.Map;
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String,String> request) {
        String username = request.get("username");
        String password = request.get("password");

        User user = authService.authenticate(username, password);
        if(user == null){
            return ResponseEntity.status(401).body("Invalid username or password");
        }

        Map<String,Object> response = new HashMap<>();
        response.put("userId", user.getId());
        response.put("role", user.getRole());

        return ResponseEntity.ok(response);
    }

    @PostMapping("/sign-up")
    public User signUp(@RequestBody User user){
        return authService.signUp(user);
    }
}