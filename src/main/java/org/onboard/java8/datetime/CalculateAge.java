package org.onboard.java8.datetime;

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
