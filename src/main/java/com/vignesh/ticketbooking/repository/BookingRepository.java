package com.vignesh.ticketbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vignesh.ticketbooking.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

}