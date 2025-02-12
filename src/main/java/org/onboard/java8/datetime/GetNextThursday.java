package org.onboard.java8.datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.function.Supplier;

public class GetNextThursday {

    static Supplier<LocalDate> supplyNextThursday = () -> {
        LocalDate today = LocalDate.now();
        int diff = today.getDayOfWeek().getValue() - DayOfWeek.THURSDAY.getValue();
        if (diff > 0) return today.plusDays(7 - diff);
        return today.plusDays(Math.abs(diff));
    };

    public static void main(String[] args) {
        System.out.println(supplyNextThursday.get());
    }
}
