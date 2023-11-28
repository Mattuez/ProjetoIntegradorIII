package com.matheus.projetointegradoriii.domain.service;

import com.matheus.projetointegradoriii.domain.model.Car;

import java.util.List;

public interface CarService {

    List<Car> getAll();
    List<Car> getAllByAvailability(boolean isAvailable);
    Car getCar(Long carId);
    Car insert(Car car);
    void delete(Long carId);
    Car activate(Long carId);
    Car deactivate(Long carId);
}
