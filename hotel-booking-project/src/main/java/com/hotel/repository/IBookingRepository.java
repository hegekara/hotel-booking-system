package com.hotel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.entities.Booking;

@Repository
public interface IBookingRepository extends JpaRepository<Booking, Long>{
    List<Booking> findByCustomer_Email(String email);
    List<Booking> findByRoom_RoomNumber(String roomNumber);
}
