package com.matheus.projetointegradoriii.domain.exception;

public class CustomerNotFoundException extends EntityNotFoundException {
    public CustomerNotFoundException(String message) {
        super(message);
    }

    public CustomerNotFoundException(Long carId) {
        this("Customer with id %d doesn't exist".formatted(carId));
    }
}
