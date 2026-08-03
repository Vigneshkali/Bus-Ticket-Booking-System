package com.vignesh.ticketbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vignesh.ticketbooking.entity.Bus;

public interface BusRepository extends JpaRepository<Bus, Integer> {

}