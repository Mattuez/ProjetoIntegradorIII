package com.matheus.projetointegradoriii.domain.service;

import com.matheus.projetointegradoriii.domain.model.Booking;

import java.util.List;

public interface BookingService {

    List<Booking> getAll();
    List<Booking> getBookingsByCustomerId(Long customerId);
    Booking getBooking(Long bookingId);
    Booking insert(Booking booking);
    Booking open(Long bookingId);
    Booking close(Long bookingId);
    void delete(Long bookingId);
}
