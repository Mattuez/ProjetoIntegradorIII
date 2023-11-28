package com.matheus.projetointegradoriii.api.model.customer;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerIdDTO {

    @NotNull
    private Long id;
}
