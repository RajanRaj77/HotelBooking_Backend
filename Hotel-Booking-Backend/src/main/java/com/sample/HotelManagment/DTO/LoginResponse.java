package com.sample.HotelManagment.DTO;

public class LoginResponse {

    private String token;
    private String role;
    private String message;

    // No-argument constructor
    public LoginResponse() {
    }

    // Three-argument constructor
    public LoginResponse(String token, String role, String message) {
        this.token = token;
        this.role = role;
        this.message = message;
    }

    // Getters
    public String getToken() {
        return token;
    }

    public String getRole() {
        return role;
    }

    public String getMessage() {
        return message;
    }

    // Setters
    public void setToken(String token) {
        this.token = token;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}