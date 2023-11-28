package com.matheus.projetointegradoriii.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(
        name = "booking"
)
@Data
@EqualsAndHashCode(
        onlyExplicitlyIncluded = true
)
public class Booking {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "id"
    )
    @EqualsAndHashCode.Include
    private Long id;

    @ManyToOne
    @JoinColumn(
            name = "customer_id",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "fk_booking_customer_customer_id"
            )
    )
    private Customer customer;

    @ManyToOne
    @JoinColumn(
            name = "car_id",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "fk_booking_car_car_id"
            )
    )
    private Car car;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;
}
