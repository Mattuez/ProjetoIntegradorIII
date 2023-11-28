package com.matheus.projetointegradoriii.api.assembler.booking;

import com.matheus.projetointegradoriii.api.model.booking.BookingDTO;
import com.matheus.projetointegradoriii.api.model.booking.BookingInputDTO;
import com.matheus.projetointegradoriii.api.model.car.CarInputDTO;
import com.matheus.projetointegradoriii.domain.model.Booking;
import com.matheus.projetointegradoriii.domain.model.Car;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class BookingDTODisassembler {

    private ModelMapper modelMapper;

    public BookingDTODisassembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Booking toEntityObject(BookingInputDTO bookingInputDTO) {
        return modelMapper.map(bookingInputDTO, Booking.class);
    }

    public void copyToEntityObject(BookingInputDTO source, Booking destination) {
        modelMapper.map(source, destination);
    }
}
