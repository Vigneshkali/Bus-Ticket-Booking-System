package com.vignesh.ticketbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vignesh.ticketbooking.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}