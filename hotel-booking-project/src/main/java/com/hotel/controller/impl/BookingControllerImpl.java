package com.hotel.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.controller.IBookingController;
import com.hotel.dto.DtoBooking;
import com.hotel.dto.DtoBookingIU;
import com.hotel.service.IBookingService;

@RestController
@RequestMapping("rest/api/booking")
public class BookingControllerImpl implements IBookingController{

    @Autowired
    private IBookingService bookingService;

    @GetMapping("/list")
    public ResponseEntity<List<DtoBooking>> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DtoBooking> getBookingById(@PathVariable Long id) {
        return bookingService.getBookingById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<DtoBookingIU> createBooking(@RequestBody DtoBookingIU dtoBookingIU) {
        return bookingService.createBooking(dtoBookingIU);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DtoBooking> updateBooking(@PathVariable Long id, @RequestBody DtoBooking updatedBooking) {
        return bookingService.updateBooking(id, updatedBooking);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> cancelBooking(@PathVariable Long id) {
        return bookingService.cancelBooking(id);
    }

    @GetMapping("/customer/{email}")
    public ResponseEntity<List<DtoBooking>> getBookingsByCustomerEmail(@PathVariable String email) {
        return bookingService.getBookingsByCustomerEmail(email);
    }

    @PatchMapping("/accept/{id}")
    public ResponseEntity<String> acceptReservation(@PathVariable Long id){
        System.out.println("\n\na");
        return bookingService.acceptReservation(id);
    }

    @PatchMapping("/reject/{id}")
    public ResponseEntity<String> rejcetReservation(@PathVariable Long id){
        return bookingService.rejectReservation(id);
    }
}