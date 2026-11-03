	package com.sample.HotelManagment.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.HotelManagment.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	// find user's by email (used for login)
	Optional<User> findByEmail(String email);
	
	// check if email already exist's
	boolean existsByEmail(String email);
}
