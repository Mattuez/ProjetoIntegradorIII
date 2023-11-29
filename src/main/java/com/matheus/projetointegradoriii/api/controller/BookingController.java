package com.matheus.projetointegradoriii.api.controller;

import com.matheus.projetointegradoriii.api.assembler.booking.BookingDTOAssembler;
import com.matheus.projetointegradoriii.api.assembler.booking.BookingDTODisassembler;
import com.matheus.projetointegradoriii.api.model.booking.BookingDTO;
import com.matheus.projetointegradoriii.api.model.booking.BookingInputDTO;
import com.matheus.projetointegradoriii.domain.exception.BusinessException;
import com.matheus.projetointegradoriii.domain.exception.EntityNotFoundException;
import com.matheus.projetointegradoriii.domain.model.Booking;
import com.matheus.projetointegradoriii.domain.service.BookingService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private BookingService bookingService;
    private BookingDTOAssembler bookingDTOAssembler;
    private BookingDTODisassembler bookingDTODisassembler;


    public BookingController(BookingService bookingService, BookingDTOAssembler bookingDTOAssembler, BookingDTODisassembler bookingDTODisassembler) {
        this.bookingService = bookingService;
        this.bookingDTOAssembler = bookingDTOAssembler;
        this.bookingDTODisassembler = bookingDTODisassembler;
    }

    @GetMapping
    public List<BookingDTO> getAll() {
        return bookingDTOAssembler.toDtoCollection(bookingService.getAll());
    }

    @GetMapping("/{bookingId}")
    public BookingDTO getById(@PathVariable("bookingId") Long bookingId) {
        return bookingDTOAssembler.toDTO(bookingService.getBooking(bookingId));
    }

    @GetMapping("/customer/{customerId}")
    public List<BookingDTO> getByCustomerId(@PathVariable("customerId") Long customerId) {
        return bookingDTOAssembler.toDtoCollection(bookingService.getBookingsByCustomerId(customerId));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookingDTO add(@RequestBody @Valid BookingInputDTO bookingInputDTO) {
        try {
            Booking booking = bookingDTODisassembler.toEntityObject(bookingInputDTO);

            return bookingDTOAssembler.toDTO(bookingService.insert(booking));
        } catch (EntityNotFoundException e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @PutMapping("/{bookingId}/opened")
    public BookingDTO open(@PathVariable("bookingId") Long bookingId) {
        return bookingDTOAssembler.toDTO(bookingService.open(bookingId));
    }

    @DeleteMapping("/{bookingId}/opened")
    public BookingDTO close(@PathVariable("bookingId") Long bookingId) {
        return bookingDTOAssembler.toDTO(bookingService.close(bookingId));
    }

    @DeleteMapping("/{bookingId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("bookingId") Long bookingId) {
        bookingService.delete(bookingId);
    }
}
