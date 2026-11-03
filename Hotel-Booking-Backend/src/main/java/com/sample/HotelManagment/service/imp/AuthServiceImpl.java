package com.sample.HotelManagment.service.imp;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sample.HotelManagment.DTO.LoginRequest;
import com.sample.HotelManagment.DTO.LoginResponse;
import com.sample.HotelManagment.DTO.RegisterRequest;
import com.sample.HotelManagment.entity.User;
import com.sample.HotelManagment.repository.UserRepository;
import com.sample.HotelManagment.security.JwtService;
import com.sample.HotelManagment.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           JwtService jwtService) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @Override
    public String register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists.");
        }

        User user = new User();

        user.setName(request.getName());

        user.setEmail(request.getEmail());

        user.setPassword(passwordEncoder.encode(request.getPassword()));

        user.setRole("USER");

        userRepository.save(user);

        return "Registration Successful";
    }

    @Override
    public LoginResponse login(LoginRequest request) {

        Optional<User> optionalUser =
                userRepository.findByEmail(request.getEmail());

        if (optionalUser.isEmpty()) {
            throw new RuntimeException("Invalid Email");
        }

        User user = optionalUser.get();

        if (!passwordEncoder.matches(
                request.getPassword(),
                user.getPassword())) {

            throw new RuntimeException("Invalid Password");
        }

        String token = jwtService.generateToken(user.getEmail());

        return new LoginResponse(
                token,
                user.getRole(),
                "Login Successful"
        );
    }

}