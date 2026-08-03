package com.vignesh.ticketbooking.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.vignesh.ticketbooking.entity.Booking;
import com.vignesh.ticketbooking.service.BookingService;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    // Book Ticket
    @PostMapping
    public Booking bookTicket(@RequestBody Booking booking) {
        return bookingService.bookTicket(booking);
    }

    // Get All Bookings
    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    // Get Booking By Id
    @GetMapping("/{id}")
    public Booking getBookingById(@PathVariable int id) {
        return bookingService.getBookingById(id);
    }

    // Cancel Booking
    @PutMapping("/cancel/{id}")
    public String cancelBooking(@PathVariable int id) {
        return bookingService.cancelBooking(id);
    }
}