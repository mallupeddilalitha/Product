package com.Junit.Testing.Validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PositivePriceValidator implements ConstraintValidator<PositivePrice , Float> {




    @Override
    public void initialize(PositivePrice constraintAnnotation) {
       // ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Float value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null) {
            return false; // Or true, depending on whether you want to allow null values.
        }
        return value >= 0;
    }

}
