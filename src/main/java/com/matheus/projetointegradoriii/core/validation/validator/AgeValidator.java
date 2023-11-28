package com.matheus.projetointegradoriii.core.validation.validator;

import com.matheus.projetointegradoriii.core.validation.annotation.AgeConstraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<AgeConstraint, Integer> {

    private int legalAge;

    @Override
    public void initialize(AgeConstraint constraintAnnotation) {
        this.legalAge = constraintAnnotation.legalAge();
    }

    @Override
    public boolean isValid(Integer age, ConstraintValidatorContext constraintValidatorContext) {

        return age > legalAge;
    }
}
