
package com.sample.HotelManagment.controller;

import com.sample.HotelManagment.DTO.BookingRequest;
import com.sample.HotelManagment.service.BookingService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;

    // Constructor Injection
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    // Create Booking
    @PostMapping
    public ResponseEntity<?> createBooking(
            @RequestBody BookingRequest bookingRequest) {

        return ResponseEntity.ok(
                bookingService.createBooking(bookingRequest)
        );
    }

    // Get All Bookings
    @GetMapping
    public ResponseEntity<?> getAllBookings() {

        return ResponseEntity.ok(
                bookingService.getAllBookings()
        );
    }

    // Get Booking By ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getBookingById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                bookingService.getBookingById(id)
        );
    }

    // Cancel Booking
    @DeleteMapping("/{id}")
    public ResponseEntity<?> cancelBooking(
            @PathVariable Long id) {

        bookingService.cancelBooking(id);

        return ResponseEntity.ok("Booking cancelled successfully");
    }
}
