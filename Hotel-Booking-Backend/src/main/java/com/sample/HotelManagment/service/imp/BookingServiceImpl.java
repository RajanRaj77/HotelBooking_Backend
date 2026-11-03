package com.sample.HotelManagment.service.imp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sample.HotelManagment.DTO.BookingRequest;
import com.sample.HotelManagment.DTO.RoomRequest;
import com.sample.HotelManagment.entity.Booking;
import com.sample.HotelManagment.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService{

	@Override
	public Booking bookRoom(Long userId, RoomRequest request) {
		return null;
	}

	@Override
	public void cancelBooking(Long bookingId) {
		
	}

	@Override
	public List<Booking> getUserBookings(Long userId) {
		return null;
	}

	@Override
	public List<Booking> getAllBookings() {
		return null;
	}

	@Override
	public Object getBookingById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object createBooking(BookingRequest bookingRequest) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
