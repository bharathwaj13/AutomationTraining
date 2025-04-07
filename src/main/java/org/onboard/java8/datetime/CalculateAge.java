package org.onboard.java8.datetime;

/**
 *
 * 1. Write a predicate to check if the given date is yesterday date.
 * 2. Write a Supplier to get Date for next Thursday.
 * 3. Write a Supplier to get CurrentTime in EST timezone
 * 4. Write a Function to calculate the age of a person given date of birth.
 */

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

public class CalculateAge {

    static Function<LocalDate,Integer> ageCalculator=(date) -> {
        return Period.between(date,LocalDate.now()).getYears();
    };

    public static void main(String[] args) {
        System.out.println("My age is: "+ageCalculator.apply(LocalDate.of(1990,03,13)));
    }
}
