package com.matheus.projetointegradoriii.api.model.customer;

import com.matheus.projetointegradoriii.core.validation.annotation.AgeConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerInputDTO {

    @NotBlank
    private String firstName;

    private String lastName;

    @Email
    private String email;

    @AgeConstraint(legalAge = 18)
    private Integer age;
}
