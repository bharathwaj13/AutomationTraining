package org.onboard.java8.datetime;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.function.Supplier;

public class GetCurrentTimeIST {

    static Supplier<ZonedDateTime> currentTime = () -> {
        return ZonedDateTime.now(ZoneId.of(ZoneId.SHORT_IDS.get("IST")));
    };

    public static void main(String[] args) {
        System.out.println(currentTime.get());
    }
}
