package com.matheus.projetointegradoriii.core.validation.validator;

import com.matheus.projetointegradoriii.core.validation.annotation.LicensePlateConstraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LicensePlateValidator implements ConstraintValidator<LicensePlateConstraint, String> {
    @Override
    public void initialize(LicensePlateConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String plate, ConstraintValidatorContext constraintValidatorContext) {

        if (plate == null) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext
                    .buildConstraintViolationWithTemplate("License plate is required")
                    .addConstraintViolation();

            return false;
        }

        if (plate.length() != 7) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext
                    .buildConstraintViolationWithTemplate("License plate must have 7 digits")
                    .addConstraintViolation();

            return false;
        }

        Pattern pattern = Pattern.compile("^[A-Z]{3}\\d{1}[A-Z]{1}\\d{2}$");
        Matcher matcher = pattern.matcher(plate);

        return matcher.matches();
    }
}
