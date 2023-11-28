package com.matheus.projetointegradoriii.core.validation.annotation;

import com.matheus.projetointegradoriii.core.validation.validator.LicensePlateValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(
    validatedBy = LicensePlateValidator.class
)
public @interface LicensePlateConstraint {

    String message() default "The license plate must follow the following pattern: 'ABC1D23'";
    Class<?>[] groups() default {};
    Class<? extends Payload> [] payload() default {};
}
