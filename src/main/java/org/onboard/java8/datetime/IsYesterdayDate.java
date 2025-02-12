package org.onboard.java8.datetime;

import java.time.LocalDate;
import java.util.function.Predicate;

public class IsYesterdayDate {

    public static Predicate<LocalDate> isYesterday = date -> {
        LocalDate yesterday = LocalDate.now().minusDays(1);
        return date.isEqual(yesterday);
    };

    public static void main(String[] args) {
        System.out.println(isYesterday.test(LocalDate.now().minusDays(1)));
        System.out.println(isYesterday.test(LocalDate.now()));
    }
}
