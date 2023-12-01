package com.vivafattura.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.Period;

public class AdultAgeValidator implements ConstraintValidator<AdultAge, LocalDate> {


    /**
     * Implements the validation logic.
     * The state of {@code value} must not be altered.
     * <p>
     * This method can be accessed concurrently, thread-safety must be ensured
     * by the implementation.
     *
     * @param dateOfBirth   object to validate
     * @param context context in which the constraint is evaluated
     * @return {@code false} if {@code value} does not pass the constraint
     */
    @Override
    public boolean isValid(LocalDate dateOfBirth, ConstraintValidatorContext context) {

        if (dateOfBirth == null) {
            return false;
        }

        LocalDate currentDate = LocalDate.now();
        Period age = Period.between(dateOfBirth, currentDate);

        // Verifica se l'età è almeno 18 anni
        return age.getYears() >= 18;
    }


}
