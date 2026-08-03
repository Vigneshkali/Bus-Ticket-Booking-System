package com.vignesh.ticketbooking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vignesh.ticketbooking.entity.Bus;
import com.vignesh.ticketbooking.repository.BusRepository;

@Service
public class BusService {

    private final BusRepository busRepository;

    public BusService(BusRepository busRepository) {
        this.busRepository = busRepository;
    }

    // Create Bus
    public Bus saveBus(Bus bus) {
        return busRepository.save(bus);
    }

    // Get All Buses
    public List<Bus> getAllBuses() {
        return busRepository.findAll();
    }

    // Get Bus By Id
    public Bus getBusById(int id) {
        Optional<Bus> bus = busRepository.findById(id);

        if (bus.isPresent()) {
            return bus.get();
        }

        return null;
    }

    // Update Bus
    public Bus updateBus(int id, Bus bus) {

        Bus existingBus = getBusById(id);

        if (existingBus != null) {

            existingBus.setBusNumber(bus.getBusNumber());
            existingBus.setBusName(bus.getBusName());
            existingBus.setSource(bus.getSource());
            existingBus.setDestination(bus.getDestination());
            existingBus.setDepartureTime(bus.getDepartureTime());
            existingBus.setArrivalTime(bus.getArrivalTime());
            existingBus.setAvailableSeats(bus.getAvailableSeats());
            existingBus.setFare(bus.getFare());

            return busRepository.save(existingBus);
        }

        return null;
    }

    // Delete Bus
    public String deleteBus(int id) {

        if (busRepository.existsById(id)) {
            busRepository.deleteById(id);
            return "Bus Deleted Successfully";
        }

        return "Bus Not Found";
    }
}