package com.vignesh.ticketbooking.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.vignesh.ticketbooking.entity.Bus;
import com.vignesh.ticketbooking.service.BusService;

@RestController
@RequestMapping("/buses")
public class BusController {

    private final BusService busService;

    public BusController(BusService busService) {
        this.busService = busService;
    }

    // Create Bus
    @PostMapping
    public Bus saveBus(@RequestBody Bus bus) {
        return busService.saveBus(bus);
    }

    // Get All Buses
    @GetMapping
    public List<Bus> getAllBuses() {
        return busService.getAllBuses();
    }

    // Get Bus By Id
    @GetMapping("/{id}")
    public Bus getBusById(@PathVariable int id) {
        return busService.getBusById(id);
    }

    // Update Bus
    @PutMapping("/{id}")
    public Bus updateBus(@PathVariable int id, @RequestBody Bus bus) {
        return busService.updateBus(id, bus);
    }

    // Delete Bus
    @DeleteMapping("/{id}")
    public String deleteBus(@PathVariable int id) {
        return busService.deleteBus(id);
    }
}