package com.matheus.projetointegradoriii.domain.exception;

public class CarNotFoundException extends EntityNotFoundException{
    public CarNotFoundException(String message) {
        super(message);
    }

    public CarNotFoundException(Long carId) {
        this("Car with id %d doesn't exists".formatted(carId));
    }
}
