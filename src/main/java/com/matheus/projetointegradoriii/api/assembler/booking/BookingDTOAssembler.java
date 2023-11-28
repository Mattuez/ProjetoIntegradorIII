package com.matheus.projetointegradoriii.api.assembler.booking;

import com.matheus.projetointegradoriii.api.model.booking.BookingDTO;
import com.matheus.projetointegradoriii.api.model.car.CarDTO;
import com.matheus.projetointegradoriii.domain.model.Booking;
import com.matheus.projetointegradoriii.domain.model.Car;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookingDTOAssembler {

    private ModelMapper modelMapper;

    public BookingDTOAssembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public BookingDTO toDTO(Booking booking) {
        return modelMapper.map(booking, BookingDTO.class);
    }

    public List<BookingDTO> toDtoCollection(List<Booking> bookings) {
        return bookings.stream()
                .map(booking -> toDTO(booking))
                .toList();
    }
}
