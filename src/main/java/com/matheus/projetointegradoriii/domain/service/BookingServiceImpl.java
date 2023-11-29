package com.matheus.projetointegradoriii.domain.service;

import com.matheus.projetointegradoriii.domain.exception.BookingNotFoundException;
import com.matheus.projetointegradoriii.domain.exception.BusinessException;
import com.matheus.projetointegradoriii.domain.model.Booking;
import com.matheus.projetointegradoriii.domain.model.BookingStatus;
import com.matheus.projetointegradoriii.domain.model.Car;
import com.matheus.projetointegradoriii.domain.model.Customer;
import com.matheus.projetointegradoriii.domain.repository.BookingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    private BookingRepository bookingRepository;
    private CustomerService customerService;
    private CarService carService;

    public BookingServiceImpl(BookingRepository bookingRepository, CustomerService customerService, CarService carService) {
        this.bookingRepository = bookingRepository;
        this.customerService = customerService;
        this.carService = carService;
    }

    @Override
    public List<Booking> getAll() {
        return bookingRepository.findAll();
    }

    @Override
    public List<Booking> getBookingsByCustomerId(Long customerId) {

        Customer customer = customerService.getCustomer(customerId);

        return customer.getBookings();
    }

    @Override
    public Booking getBooking(Long bookingId) {

        return bookingRepository.findById(bookingId)
                .orElseThrow(() -> new BookingNotFoundException(bookingId));
    }

    @Override
    @Transactional
    public Booking insert(Booking booking) {

        Customer customer = customerService.getCustomer(booking.getCustomer().getId());
        Car car = carService.getCar(booking.getCar().getId());

        if (!car.getIsAvailable()) {
            throw new BusinessException("The car with id %d is not available".formatted(car.getId()));
        }

        car.setIsAvailable(false);

        booking.setCustomer(customer);
        booking.setCar(car);
        booking.setStatus(BookingStatus.OPENED);

        return bookingRepository.save(booking);
    }

    @Override
    public Booking open(Long bookingId) {
        Booking booking = getBooking(bookingId);
        Car car = booking.getCar();

        if (booking.getStatus().equals(BookingStatus.OPENED)) {
            throw new BusinessException("Booking is already opened");
        }

        if (!car.getIsAvailable()) {
            throw new BusinessException("The car with id %d is not available".formatted(car.getId()));
        }

        car.setIsAvailable(false);

        booking.setStatus(BookingStatus.OPENED);

        return bookingRepository.save(booking);
    }

    @Override
    @Transactional
    public Booking close(Long bookingId) {

        Booking booking = getBooking(bookingId);

        if (booking.getStatus().equals(BookingStatus.CLOSED)) {
            throw new BusinessException("Booking is already closed");
        }

        booking.getCar().setIsAvailable(true);

        booking.setStatus(BookingStatus.CLOSED);

        return bookingRepository.save(booking);
    }

    @Override
    public void delete(Long bookingId) {

        Booking booking = getBooking(bookingId);

        if (booking.getStatus().equals(BookingStatus.OPENED)) {
            throw new BusinessException("Opened bookings can't be deleted");
        }

        bookingRepository.delete(booking);
    }
}
