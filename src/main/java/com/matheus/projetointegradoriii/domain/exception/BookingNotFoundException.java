package com.matheus.projetointegradoriii.domain.exception;

public class BookingNotFoundException extends EntityNotFoundException {
    public BookingNotFoundException(String message) {
        super(message);
    }

    public BookingNotFoundException(Long bookingId) {
        this("Booking with id %d doesn't exists".formatted(bookingId));
    }
}
