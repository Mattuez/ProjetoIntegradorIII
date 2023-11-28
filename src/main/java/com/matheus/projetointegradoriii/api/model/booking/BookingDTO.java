package com.matheus.projetointegradoriii.api.model.booking;

import com.matheus.projetointegradoriii.api.model.car.CarIdDTO;
import com.matheus.projetointegradoriii.api.model.customer.CustomerIdDTO;
import com.matheus.projetointegradoriii.domain.model.BookingStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingDTO {

    private Long id;

    private CustomerIdDTO customer;

    private CarIdDTO car;

    private BookingStatus status;
}
