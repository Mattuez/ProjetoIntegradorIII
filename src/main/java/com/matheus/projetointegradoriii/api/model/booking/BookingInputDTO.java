package com.matheus.projetointegradoriii.api.model.booking;

import com.matheus.projetointegradoriii.api.model.car.CarIdDTO;
import com.matheus.projetointegradoriii.api.model.customer.CustomerIdDTO;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingInputDTO {

    @NotNull
    private CustomerIdDTO customer;

    @NotNull
    private CarIdDTO car;

}
