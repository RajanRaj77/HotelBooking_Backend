package com.sample.HotelManagment.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sample.HotelManagment.DTO.LoginRequest;
import com.sample.HotelManagment.DTO.LoginResponse;
import com.sample.HotelManagment.DTO.RegisterRequest;
import com.sample.HotelManagment.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(
            @RequestBody RegisterRequest request) {

        String response =
                authService.register(request);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
            @RequestBody LoginRequest request) {

    	return ResponseEntity.ok(authService.login(request));
    }
}