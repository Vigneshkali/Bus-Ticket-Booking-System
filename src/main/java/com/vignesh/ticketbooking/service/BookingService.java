package com.vignesh.ticketbooking.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vignesh.ticketbooking.entity.Booking;
import com.vignesh.ticketbooking.entity.Bus;
import com.vignesh.ticketbooking.repository.BookingRepository;
import com.vignesh.ticketbooking.repository.BusRepository;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final BusRepository busRepository;

    public BookingService(BookingRepository bookingRepository,
                          BusRepository busRepository) {
        this.bookingRepository = bookingRepository;
        this.busRepository = busRepository;
    }

    // Book Ticket
    public Booking bookTicket(Booking booking) {

        Bus bus = booking.getBus();

        Bus existingBus = busRepository.findById(bus.getId()).orElse(null);

        if (existingBus == null) {
            return null;
        }

        if (existingBus.getAvailableSeats() <= 0) {
            return null;
        }

        existingBus.setAvailableSeats(existingBus.getAvailableSeats() - 1);

        busRepository.save(existingBus);

        booking.setBookingDate(LocalDate.now());
        booking.setStatus("BOOKED");

        return bookingRepository.save(booking);
    }

    // Get All Bookings
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    // Get Booking By Id
    public Booking getBookingById(int id) {

        Optional<Booking> booking = bookingRepository.findById(id);

        return booking.orElse(null);
    }

    // Cancel Booking
    public String cancelBooking(int id) {

        Booking booking = getBookingById(id);

        if (booking == null) {
            return "Booking Not Found";
        }

        Bus bus = booking.getBus();

        bus.setAvailableSeats(bus.getAvailableSeats() + 1);

        busRepository.save(bus);

        booking.setStatus("CANCELLED");

        bookingRepository.save(booking);

        return "Booking Cancelled Successfully";
    }
}