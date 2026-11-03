package com.sample.HotelManagment.service;

import java.util.List;

import com.sample.HotelManagment.entity.User;

public interface UserService {

	User getUserById(Long id);
	
	List<User> getAllUser();
	
	void deleteUser(Long Id);
}
