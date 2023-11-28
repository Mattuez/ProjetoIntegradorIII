package com.matheus.projetointegradoriii.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Entity
@Table(
        name = "car",
        uniqueConstraints = {
                @UniqueConstraint(name = "UQ_car_plate", columnNames = "plate")
        }
)
@Data
@EqualsAndHashCode(
        onlyExplicitlyIncluded = true
)
public class Car {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "id",
            updatable = false
    )
    @EqualsAndHashCode.Include
    private Long id;

    @Column(
            name = "plate",
            nullable = false,
            unique = true,
            length = 7
    )
    private String licensePlate;

    @Column(
            name = "brand"
    )
    private String brand;

    @Column(
            name = "model",
            nullable = false
    )
    private String model;

    @Column(
            name = "rental_price_per_day",
            nullable = false
    )
    private BigDecimal rentalPricePerDay;

    @Enumerated(EnumType.STRING)
    @Column(
            name = "type",
            nullable = false
    )
    private CarType carType;

    @Column(
            name = "is_available",
            nullable = false
    )
    private Boolean isAvailable;
}
