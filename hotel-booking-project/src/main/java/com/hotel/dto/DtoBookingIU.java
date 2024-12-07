package com.hotel.dto;

import java.time.LocalDate;

import com.hotel.constants.BookingStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoBookingIU {

    private String email;

    private String roomNumber;

    private LocalDate checkInDate;

    private LocalDate checkOutDate;

    private BookingStatus bookingStatus;
}