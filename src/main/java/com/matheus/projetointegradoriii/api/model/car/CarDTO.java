package com.matheus.projetointegradoriii.api.model.car;

import com.matheus.projetointegradoriii.domain.model.CarType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CarDTO {

    private Long id;

    private String licensePlate;

    private String brand;

    private String model;

    private BigDecimal rentalPricePerDay;

    private CarType carType;

    private Boolean isAvailable;
}
