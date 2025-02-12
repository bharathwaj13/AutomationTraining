package org.onboard.java8.consumersupplier;

import java.util.Random;
import java.util.function.Supplier;

public class OTPSupplier {

    public static void main(String[] args) {

        Supplier<String> supplier = () -> {
            Random random=new Random();
            int number= 100000 + random.nextInt(900000);
            return String.valueOf(number);
        };
        String otp = supplier.get();
        System.out.println(otp);

    }
}
