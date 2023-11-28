package com.matheus.projetointegradoriii.core.validation.annotation;

import com.matheus.projetointegradoriii.core.validation.validator.AgeValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(
        validatedBy = AgeValidator.class
)
public @interface AgeConstraint {

    String message() default "{LegalAge}";
    Class<?>[] groups() default {};
    Class<? extends Payload> [] payload() default {};

    int legalAge();
}
