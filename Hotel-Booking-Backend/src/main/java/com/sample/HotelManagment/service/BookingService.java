package com.sample.HotelManagment.service;

import java.util.List;

import com.sample.HotelManagment.DTO.BookingRequest;
import com.sample.HotelManagment.DTO.RoomRequest;
import com.sample.HotelManagment.entity.Booking;

public interface BookingService {

	Booking bookRoom(Long userId, RoomRequest request);
	
	void cancelBooking(Long bookingId);
	
	List<Booking> getUserBookings(Long userId);
	
	List<Booking> getAllBookings();

	Object getBookingById(Long id);

	Object createBooking(BookingRequest bookingRequest);
	
}
