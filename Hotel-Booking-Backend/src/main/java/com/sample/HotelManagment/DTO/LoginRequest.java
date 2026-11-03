package com.sample.HotelManagment.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {

	@NotBlank(message = "email is requered")
	private String email;
	
	@NotBlank(message = "password is requered")
	private String password;

	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
	
	
	
}
