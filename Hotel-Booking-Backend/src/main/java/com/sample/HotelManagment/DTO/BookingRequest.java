package com.sample.HotelManagment.DTO;

import java.time.LocalDate;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BookingRequest {

	@NotNull(message = "Check-in date is requered")
	@Future(message = "Check-in date must be in future")
	private LocalDate checkInDate;
	
	@NotNull(message = "Check-out date is requred")
	@Future(message = "check-out date is must be in future")
	private LocalDate CheckOutDate;
	
	@NotNull(message = "Room id must be requered")
	private Long roomId;
	
	@NotNull(message = "Number of gueste must be requered")
	private Integer numberOfGuests;
	
}
