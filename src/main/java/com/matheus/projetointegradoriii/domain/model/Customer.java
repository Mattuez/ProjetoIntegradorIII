package com.matheus.projetointegradoriii.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(
        name = "customer",
        uniqueConstraints =
                @UniqueConstraint(name = "UQ_customer_email", columnNames = "email")
)
@Data
@EqualsAndHashCode(
        onlyExplicitlyIncluded = true
)
public class Customer {

    @Id
    @GeneratedValue(
            strategy = IDENTITY
    )
    @Column(
            name = "id",
            updatable = false
    )
    @EqualsAndHashCode.Include
    private Long id;

    @Column(
            name = "first_name",
            nullable = false
    )
    private String firstName;

    @Column(
            name = "last_name"
    )
    private String lastName;

    @Column(
            name = "email",
            nullable = false,
            unique = true
    )
    private String email;

    @Column(
            name = "age",
            nullable = false
    )
    private Integer age;

    @OneToMany(
            mappedBy = "customer"
    )
    private List<Booking> bookings;
}
