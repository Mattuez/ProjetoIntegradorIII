package com.matheus.projetointegradoriii.api.model.car;

import com.matheus.projetointegradoriii.core.validation.annotation.LicensePlateConstraint;
import com.matheus.projetointegradoriii.domain.model.CarType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CarInputDTO {

    @LicensePlateConstraint
    private String licensePlate;

    private String brand;

    @NotBlank
    private String model;

    @NotNull
    @Positive
    private BigDecimal rentalPricePerDay;

    @NotNull
    private CarType carType;

}
