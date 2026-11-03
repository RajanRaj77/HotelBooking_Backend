package com.sample.HotelManagment.service;

import com.sample.HotelManagment.DTO.LoginRequest;
import com.sample.HotelManagment.DTO.LoginResponse;
import com.sample.HotelManagment.DTO.RegisterRequest;

public interface AuthService {

	String register(RegisterRequest request);
	
	LoginResponse login(LoginRequest request);
	
}
