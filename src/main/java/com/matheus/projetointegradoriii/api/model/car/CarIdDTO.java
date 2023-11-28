package com.matheus.projetointegradoriii.api.model.car;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarIdDTO {

    @NotNull
    private Long id;
}
