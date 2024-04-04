package com.movie.controller;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AadharSequenceValidator implements ConstraintValidator<AadharSequence, String> {

    @Override
    public void initialize(AadharSequence constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true; // Return true for null values (if not required)
        }

        // Check for continuous sequences of numbers
        if (value.matches("(\\d)\\1{11}")) {
            return false; // Return false if continuous sequence is found
        }

        return true; // Return true if the value is valid
    }
}
