package org.onboard.java8.primitivefunctionalinterface;

/**
 *
 * PreConditions
 * - Define a Product class with name, price, category, grade
 *
 * 1. Write an IntPredicate to verify if the given number is a primenumber
 * 2. Write an IntConsumer to print square of the given number
 * 3. Write a IntSupplier to give random int below 5000.
 */


import java.util.Random;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;

public class PrimeNumberCheck {

    static IntPredicate intPredicate = num -> {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    };

    static IntConsumer intConsumer = num -> System.out.println(num*num);

    static Random random = new Random();

    static IntSupplier intSupplier = () -> random.nextInt(5000);

    public static void main(String[] args) {
        if (intPredicate.test(10)) System.out.println("The given number is prime");
        else System.out.println("The given number is not prime");

        intConsumer.accept(3);

        System.out.println(intSupplier.getAsInt());
    }

}
