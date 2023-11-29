package com.matheus.projetointegradoriii.domain.service;

import com.matheus.projetointegradoriii.domain.exception.BusinessException;
import com.matheus.projetointegradoriii.domain.exception.CarNotFoundException;
import com.matheus.projetointegradoriii.domain.exception.EntityBeingUsedException;
import com.matheus.projetointegradoriii.domain.exception.UniqueResourceBeingUsed;
import com.matheus.projetointegradoriii.domain.model.Booking;
import com.matheus.projetointegradoriii.domain.model.BookingStatus;
import com.matheus.projetointegradoriii.domain.model.Car;
import com.matheus.projetointegradoriii.domain.repository.CarRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService{

    private CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> getAll() {
        return carRepository.findAll();
    }

    @Override
    public List<Car> getAllByAvailability(boolean isAvailable) {
        return carRepository.getCarByIsAvailable(isAvailable);
    }

    @Override
    public Car getCar(Long carId) {
        return carRepository.findById(carId)
                .orElseThrow(() -> new CarNotFoundException(carId));
    }

    @Override
    @Transactional
    public Car insert(Car car) {
        try {
            car.setIsAvailable(true);

            return carRepository.save(car);
        } catch (DataIntegrityViolationException e) {
            throw new UniqueResourceBeingUsed("License plate", car.getLicensePlate());
        }
    }

    @Override
    @Transactional
    public void delete(Long carId) {
        Car car = getCar(carId);

        try {
            carRepository.delete(car);
        } catch (DataIntegrityViolationException e) {
            throw new EntityBeingUsedException(car.getClass().getSimpleName(), carId);
        }
    }

    @Override
    @Transactional
    public Car activate(Long carId) {
        Car car = getCar(carId);
        Optional<Booking> booking = lookForOpenedBooking(car);

        if (booking.isPresent()) {
            throw new BusinessException(
                    ("The booking with id %d is opened and using this car. " +
                            "Therefore it cant be activated").formatted(booking.get().getId())
            );
        }

        if (car.getIsAvailable()) {
            throw new BusinessException("Car is already activated");
        }

        car.setIsAvailable(true);

        return car;
    }

    @Override
    @Transactional
    public Car deactivate(Long carId) {
        Car car = getCar(carId);

        if (!car.getIsAvailable()) {
            throw new BusinessException("Car is already deactivate");
        }

        car.setIsAvailable(false);

        return car;
    }

    private Optional<Booking> lookForOpenedBooking(Car car) {
        return car.getBookings().stream()
                .filter(booking -> booking.getStatus().equals(BookingStatus.OPENED))
                .findFirst();
    }
}
