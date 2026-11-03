package com.sample.HotelManagment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.HotelManagment.entity.Booking;
import com.sample.HotelManagment.entity.Room;
import com.sample.HotelManagment.entity.User;

public interface BookingRepository extends JpaRepository<Booking, Long>{
	
	//Get booking bby user
	List<Booking> findByUser(User user);
	
	//Get booking by room
	List<Booking> findByRoom(Room room);
	
	//Find booking user status
	List<Booking> findByBookingStatus(String status);

}
